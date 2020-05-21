# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.7.RELEASE/maven-plugin/)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.2.7.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

For mongo in docker
docker pull mongo:latest

C:\dev\sts-workspace\userservice>docker run -d -p 27017:27017 --name mymongodb mongo:latest

spring-jar-for service:
C:\dev\sts-workspace\userservice>java -jar .\target\kapilrep-userservice-spring-boot-docker-0.0.1-SNAPSHOT.jar

build a container
docker build -t userservice-spring-boot-docker .

C:\dev\sts-workspace\userservice>docker run -p 8080:8080 userservice-spring-boot-docker

Run mongodb and link it to userservice container

C:\dev\sts-workspace\userservice>docker run -p 8080:8080 userservice-spring-boot-docker --link mymongodb:mongo -d userservice-spring-boot-docker:latest

docker build -t kmadan73/userservice-mongo .

docker push kmadan73/userservice-mongo