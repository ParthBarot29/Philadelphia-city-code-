# Running the application 
## Run in standalone 
  1. Install dependencies
    $ pip install -r requirements.txt 
  2. Run database migrations by running the following commands on CMD
  NB: This should be within the project folder
    $ flask db init 
    $ flask db migrate 
    $ flask db upgrade 
  3. Run the application using 
    $ flask run 
    OR 
    $ python app.py runserver
  4. Access the application on port 5000 using the following URL:
      http://localhost:5000/
## Run the application in docker container 
  1. Build the docker image by running the following command on project DIR 
      $ docker build -t phila-gov .
  2. Run the image in interactive mode
      $ docker run -it phila-gov
  3. Access the application
      http://localhost:5000/
