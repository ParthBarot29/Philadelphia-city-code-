import json
import traceback

from database_models import app, manager, search_data
from flask import render_template
from flask import request, jsonify


@app.route("/api/search", methods=["POST"])
def search_service():
    """
    Search for data from this API

    :return:
    """
    data = request.json
    try:
        response = search_data(data)
        return app.response_class(
            response=json.dumps(response, encoding='utf-8', ensure_ascii=False),
            status=200,
            mimetype='application/json'
        )
    except Exception as ex:
        traceback.print_exc(ex)
        app.logger.critical("Error processing request")
        return jsonify({
            "customer_information": {},
            "appendix": {},
            "tax_info": [],
            "error": "Server error: %s" % (repr(ex)),
            "valid": False
        })


@app.route("/")
def display_main():
    """
    Display main file for
    :return:
    """
    return render_template('index.html')


def main():
    """
    Start a small web server

    :return:
    """
    app.config["PORT"] = 8081
    app.config["HOST"] = "0.0.0.0"
    manager.run()


if __name__ == '__main__':
    main()
