### Prerequisites

JDK 17+

IntelliJ IDEA 2024.1 (Ultimate Edition)

Install Android SDK: Go to Setting -> Language&Frameworks -> SDK, select latest sdk version, download and apply it

Gradle 8.7

Clone Project: https://github.com/koumiaomiao/hcbc-service

### Run Spring Boot project in docker

Enter root directory: hcbc-service

Sync project

Start project: ./gradlew clean bootRun

Build jar file: ./gradlew clean bootJar

Install docker and login

Generate docker image:  docker build -t koumiaomiao/hcbc:0.0.1 . [mongodb url host: localhost]

Push service image to dockerhub: docker push koumiaomiao/hcbc:0.0.1 [need to login to access docker hub]

Start docker and pull mongodb image and generate a container

Start service in docker: docker run -p 8088:8088 koumiaomiao/hcbc:0.0.1

### Deploy to AWS

Login AWS, Enter Elastic Container Service

Create AWS Cluster, Define mongodb task using dockerhub latest mongo image [port:27017]

Run mongo server and get it's public ip address, using mongodb compass test connection

Open application.properties file, replace mongodb host to public ip address provided by aws

Re-Run service image packaging process

Define service task using service image, which is finally be published to dockerhub.

Run service server and get it's public address

Start app using public address


### Architecture

MVC Architecture: https://spring.io/projects/spring-boot


### CI/CD

Login AWS, Enter Elastic Container Service

Create AWS Cluster, Define jenkins task using dockerhub latest jenkins image version: jenkins. Notice not jenkins:2.60.3

Run jenkins server and get it's public ip address

Chrome access jenkins public ip and config jenkins environment, init password can be found in jenkins task log

Pipeline is multi-branch style, execute task by jenkins file built-in app project