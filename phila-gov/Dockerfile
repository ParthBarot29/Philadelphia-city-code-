FROM python:2.7-slim
# Copy project to docker container
ENV APP_DIR /app
COPY . $APP_DIR
ENV APP_PORT 8081

EXPOSE $APP_PORT
WORKDIR $APP_DIR

# Install requirements
RUN pip install -r requirements.txt

# RUn migrations and database upgrade
RUN flask db migrate
RUN flask db upgrade
# Start Flak application server
CMD ["python", "/app/app.py", "runserver","--port","8081","--host","0.0.0.0"]