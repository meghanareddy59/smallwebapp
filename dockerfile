
#FROM openjdk:8-jre-alpine
#FROM davidcaste/alpine-tomcat AS stage1
#From maven:3.5.2-jdk-8-alpine AS stage1

#WORKDIR app/
#COPY . .
#RUN mvn clean install
#FROM tomcat:jdk8-openjdk
#COPY --from=stage1 /app/target/root.war /usr/local/tomcat/webapps

FROM openjdk:8-jre-alpine
FROM apt-get install -y git-core

RUN mkdir tomcat
WORKDIR tomcat
#RUN apt-get install wget
RUN wget https://archive.apache.org/dist/tomcat/tomcat-8/v8.5.34/bin/apache-tomcat-8.5.34.tar.gz
RUN tar xvfz apache-tomcat-8.5.34.tar.gz


