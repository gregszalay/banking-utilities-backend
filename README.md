# Banking Utilities App

### Rest API backend for payment card validation and mortgage payment calculation.

### Detailed API documentation & examples: https://app.swaggerhub.com/apis/gregszalay/bankingapplicationAPI/1.0.0-oas3#/

### Prerequisities

In order to run this container you'll need docker installed.

* [Windows](https://docs.docker.com/windows/started)
* [OS X](https://docs.docker.com/mac/started/)
* [Linux](https://docs.docker.com/linux/started/)

### Build

Steps to build a Docker image:

1. Clone this repo 
   
         git clone git@github.com:gregszalay/banking-utilities-backend.git

2. Build the image 
   
         docker build -t bankingutilities-webapp .

   This could take a few minutes.


4. Run the image's default command, which should start everything up. The `-p` option forwards the container's port 8080
   to port 8080 on the host. 
   
         docker run -p 8080:8080 bankingutilities-webapp

5. Once everything has started up, you should be able to access the webapp via [http://localhost:8000/] on your host
   machine. Open: http://localhost:8080/ in your favourite browser.
