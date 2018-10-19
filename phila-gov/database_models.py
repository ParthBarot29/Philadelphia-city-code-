import json
from flask_script import Manager
from flask import Flask
from flask_sqlalchemy import SQLAlchemy
from sqlalchemy import or_

from flask_migrate import Migrate, MigrateCommand
from config import Config
import re
from datetime import datetime
from web_scrapping.philadelphia_spider import find_from_site

app = Flask(__name__)
app.config.from_object(Config)

db = SQLAlchemy(app)
migrate = Migrate(app, db)

manager=Manager(app)
manager.add_command("db",MigrateCommand)
app.config['SECRET_KEY'] = 'john23:1'


class CustomerInformation(db.Model):
    __tablename__ = "customer_information"
    brt_number = db.Column(db.String(80), primary_key=True)
    property_address = db.Column(db.String(512))
    postal_code = db.Column(db.String(80))
    owner_name = db.Column(db.String(256))
    lien_sale_account = db.Column(db.String(5))
    payments_through = db.Column(db.String(20))
    created_on = db.Column(db.DateTime, default=datetime.utcnow)
    updated_at = db.Column(db.DateTime, default=datetime.utcnow)

    def to_dict(self):
        return {
            "brt_number": str(self.brt_number),
            "property_address": str(self.property_address),
            "postal_code": str(self.postal_code),
            "owner_name": str(self.owner_name),
            "lien_sale_account": str(self.lien_sale_account),
            "payments_through": str(self.payments_through),
            "created_on": str(self.created_on),
            "updated_at": str(self.updated_at)
        }

    def __repr__(self):
        return "<CustomerInformation brn_number=%s>" % self.brt_number


class RealEstateTax(db.Model):
    __tablename__ = "real_estate_tax"
    id = db.Column(db.Integer, primary_key=True)
    brt_number = db.Column(db.String(80))
    year = db.Column(db.String(5))
    principal = db.Column(db.Float)
    interest = db.Column(db.Float)
    penalty = db.Column(db.Float)
    other_charges = db.Column(db.Float)
    total_charges = db.Column(db.Float)
    lien_number = db.Column(db.String(80))
    city_solicitor = db.Column(db.String(512))
    tax_status = db.Column(db.String)
    currency = db.Column(db.String(5), default="$")
    created_on = db.Column(db.DateTime, default=datetime.utcnow)
    updated_at = db.Column(db.DateTime, default=datetime.utcnow)

    def to_dict(self):
        return {
            "brt_number": str(self.brt_number),
            "year": str(self.year),
            "principal": str(self.principal),
            "interest": str(self.interest),
            "penalty": str(self.penalty),
            "other": str(self.other_charges),
            "total": str(self.total_charges),
            "lien_number": self.lien_number,
            "city_solicitor": self.city_solicitor,
            "status": self.tax_status,
            "currency": self.currency
        }

    def __repr__(self):
        return "<RealEstateTax year=%s>" % self.year


class StatusDescriptions(db.Model):
    __tablename__ = "status_description"
    status_value = db.Column(db.String(10), primary_key=True)
    description = db.Column(db.String(512))
    created_on = db.Column(db.DateTime, default=datetime.utcnow)
    updated_at = db.Column(db.DateTime, default=datetime.utcnow)

    def to_dict(self):
        return {
            "status_value": str(self.status_value),
            "description": str(self.description)
        }

    def __repr__(self):
        return "<StatusDescriptions status=%s>" % self.status_value


def save_customer_info(info):
    """
    create a customer account if one does not exist, return existing one

    :param info:
    :return:
    """
    brt_no = info.get("brt", "")

    if len(brt_no) > 0:
        exists = CustomerInformation.query.filter(CustomerInformation.brt_number == brt_no).first()
        if exists is None:
            cust = CustomerInformation(brt_number=info.get("brt", ''),
                                       property_address=info.get("property_address", ''),
                                       lien_sale_account=info.get("lien_sale_account", ''),
                                       owner_name=info.get("owner_name", ''),
                                       postal_code=info.get("postal_code", ''),
                                       payments_through=info.get("includes_payments_through", ''))
            u = db.session.add(cust)
            db.session.commit()
            return u

        else:
            return exists
    else:
        return None


def add_all_descriptions(descriptions):
    """
    Add all status descriptions

    :param descriptions:
    :return:
    """
    for v in descriptions:
        f = StatusDescriptions.query.filter(StatusDescriptions.status_value == v.get('status_value', '')).first()
        if f is None:
            fd = StatusDescriptions(status_value=v.get('status_value', ''), description=v.get('description', ''))
            db.session.add(fd)
    db.session.commit()


def to_float(dt):
    """
    Convert dolar string to float
    :param dt:
    :return:
    """
    try:
        return float(re.sub("\$|[^0-9]+", '', dt).strip())
    except Exception as ex:
        return 0.0


def add_tax_information(tax_data, brt_no):
    """
    Save all tax information if they don't exist

    :param tax_data:
    :param brt_no:
    :return:
    """
    for tax in tax_data:
        f = RealEstateTax.query.filter(RealEstateTax.year == tax.get("year", ""),
                                       RealEstateTax.brt_number == brt_no).first()
        if f is None:
            dt = RealEstateTax(
                brt_number=brt_no,
                year=tax.get("year", ""),
                principal=to_float(tax.get("principal", "0")),
                penalty=to_float(tax.get("penalty", "0")),
                other_charges=to_float(tax.get("other", "0")),
                lien_number=tax.get("lien", "0"),
                tax_status=tax.get("status", ""),
                interest=to_float(tax.get("interest", "0")),
                city_solicitor=tax.get("city_solicitor", ""),
                total_charges=to_float(tax.get("total", "0"))
            )
            db.session.add(dt)
    db.session.commit()


def model_to_json(models):
    if isinstance(models, list):
        values = []
        for m in models:
            values.append(m.to_dict())
        return values
    else:
        return []


def get_if_exists(brt_no=None, address=None):
    """
    Get Data from local database

    :param brt_no:
    :param address:
    :return:c
    """
    if brt_no is None and address is None:
        return False, {}
    customer = CustomerInformation.query.filter(
        or_(CustomerInformation.brt_number == brt_no, CustomerInformation.property_address == address)).first()
    if customer is None:
        data = find_from_site(br_id=brt_no, address=address)
        if data.get("valid", False):
            cust_details = data.get("customer_information", {})
            save_customer_info(cust_details)
            brt_n = cust_details.get("brt", "")
            add_tax_information(data.get("tax_info", []), brt_n)
            add_all_descriptions(data.get("appendix", []))
        return True, data
    else:
        legend = StatusDescriptions.query.all()
        tax_info = RealEstateTax.query.filter(RealEstateTax.brt_number == brt_no).order_by(RealEstateTax.year).all()
        return True, {
            "customer_information": customer.to_dict(),
            "appendix": model_to_json(legend),
            "tax_info": model_to_json(tax_info),
            "error": None,
            "valid": True
        }


def search_data(data):
    """
    Search for data locally or search from Philadelphia website

    :param data:
    :return:
    """
    search_type = data.get("search_type", None)
    if search_type is None:
        return {
            "customer_information": {},
            "appendix": {},
            "tax_info": [],
            "error": "Invalid Search Type ",
            "valid": False
        }
    elif search_type == "brt":
        exists, data = get_if_exists(data.get("search_value", None), None)
        if exists:
            return data
    elif search_type == "address":
        exists, data = get_if_exists(None, data.get("search_value", None))
        if exists:
            return data
    return {
        "customer_information": {},
        "appendix": {},
        "tax_info": [],
        "error": "Invalid Search Type %s" % search_type,
        "valid": False
    }
