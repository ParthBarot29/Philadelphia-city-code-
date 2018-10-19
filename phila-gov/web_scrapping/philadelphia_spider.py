import mechanize
import cookielib
from bs4 import BeautifulSoup
import re
import json


def retrieve_data(html):
    """
    Parse HTML response to JSON data

    :param html:
    :return:
    """
    soup = BeautifulSoup(html)
    error = soup.find_all("span", {"class": "error"})
    if len(error) > 0 and len(error[0].text) > 0:
        return {
            "tax_info": [],
            "customer_information": {},
            "appendix": {},
            "error": error[0].text,
            "valid": False
        }
    cust_info_table = soup.find_all(id="ctl00_BodyContentPlaceHolder_GetTaxInfoControl_frm")[0]
    cust_info_table.find_all("tr")
    # 1. Retrieve customer information
    cust_data = {}
    for div in cust_info_table.find_all("div"):
        spans = div.find_all("span")
        if len(spans) > 1:
            ll = re.sub('[:|#]', '', spans[0].text)
            label = re.sub('[^A-Za-z0-9]+', '_', ll)
            text = spans[1].text
            cust_data[label.lower()] = text
    # print(cust_data)
    # 2. Retrieve legend descriptions
    appendix_info = []
    for div in soup.find_all("div", {"class": "legendDescrip"}):
        label = div.find_all("span")
        if len(label) > 0:
            text = label[0].text
            label[0].extract()
            description = div.text
            appendix_info.append({"status_value": text, "description": description.strip().strip("-").strip()})
    # print(appendix_info)
    # 3. Retrieve tax information
    data_table = soup.find("table", {"class": "grdRecords"})
    data_vales = []
    if data_table is not None:
        # 3.1 Retrieve header information
        headers = data_table.find("tr", {"class": "grdHeader"})
        titles = {}
        for idx, td in enumerate(headers.find_all("th")):
            tx = re.sub("[#|:]+", '', td.text.lower()).strip()
            titles[idx] = re.sub("\s", "_", tx)
        headers.extract()
        # 3.2 Retrieve taxation information
        for tr in data_table.find_all("tr"):
            values = {}
            for idx, td in enumerate(tr.find_all("td")):
                values[titles[idx]] = td.text
            data_vales.append(values)
    # 4. Respond with customer data
    return {
        "tax_info": data_vales,
        "customer_information": cust_data,
        "appendix": appendix_info,
        "valid": True,
        "error": None
    }


def find_from_site(br_id=None, address=None):
    """
    Make site request and return JSON

    :param br_id:
    :param address:
    :return:
    """
    if br_id is None and address is None:
        return {
            "tax_info": [],
            "customer_information": {},
            "appendix": {},
            "error": "Please enter address or BRT Number",
            "valid": False
        }
    br = mechanize.Browser()
    br.set_cookiejar(cookielib.LWPCookieJar())
    # Browser options
    br.set_handle_equiv(True)
    br.set_handle_gzip(True)
    br.set_handle_redirect(True)
    br.set_handle_referer(True)
    br.set_handle_robots(False)

    # Follows refresh 0 but not hangs on refresh > 0
    br.set_handle_refresh(mechanize._http.HTTPRefreshProcessor(), max_time=1)
    br.open("http://legacy.phila.gov/revenue/realestatetax/")
    res = br.response()
    # print(res.read())
    for f in br.forms():
        print("Form: %s" % f.name)
    br.select_form(nr=0)
    web_form = br.forms()[0]
    if len(br_id) > 0:
        brt = web_form.find_control(id="ctl00_BodyContentPlaceHolder_SearchByBRTControl_txtTaxInfo")
        brt.value = br_id
        br.submit(id="ctl00_BodyContentPlaceHolder_SearchByBRTControl_btnTaxByBRT")
    else:
        brt = web_form.find_control(id="ctl00_BodyContentPlaceHolder_SearchByAddressControl_txtLookup")
        brt.value = address
        br.submit(id="ctl00_BodyContentPlaceHolder_SearchByAddressControl_btnLookup")
    res = br.response()
    html = res.read()
    return retrieve_data(html)


if __name__ == "__main__":
    print(json.dumps(find_from_site(br_id="161113200"), indent=2))
