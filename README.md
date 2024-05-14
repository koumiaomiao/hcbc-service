### Prerequisites

- JDK 17+ 
- IntelliJ IDEA 2024.1 (Ultimate Edition)
- Gradle: brew install gradle 
- Clone Project: `git clone git@github.com:koumiaomiao/hcbc-service.git`

### Start local server

Enter root directory: hcbc-service and start project

``````bash
./gradlew bootRun
``````

### Publish project to docker

Build jar file

``````bash
./gradlew clean bootJar
``````

[Install docker and login](https://formulae.brew.sh/formula/docker)

Generate docker image

``````bash
docker build -t koumiaojuan/hcbc:0.0.1 .
``````

Push service image to dockerhub

``````bash
docker push koumiaojuan/hcbc:0.0.1 [need to login to access docker hub]
``````

### Deploy to AWS

- Login AWS, Enter Elastic Container Service

- Create AWS Cluster, Define mongodb task using dockerhub latest mongo image, the mongodb task port is 27017
- Run mongo server and get it's public ip address, using mongodb compass test connection
- Open application.properties file, replace mongodb localhost to public ip address provided by aws
- Re-Run `publish project to docker` process
- Define hcbc-service task using hcbc-service image, named `koumiaojuan/hcbc:0.0.1`, which is finally be published to dockerhub.
- Run hcbc-service server and get it's public address

### How to use 

See the `Connect to server` of [README](https://github.com/koumiaomiao/android-hcbc) to see detail


### Architecture

MVC Architecture: https://spring.io/projects/spring-boot

### CI/CD

See the `CI/CD` section of [README](https://github.com/koumiaomiao/android-hcbc) to see detail