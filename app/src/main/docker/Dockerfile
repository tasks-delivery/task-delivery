
FROM frolvlad/alpine-oraclejdk8:slim

VOLUME /tmp
VOLUME /opt/podcast-server
ADD app.jar /opt/podcast-server/app.jar
RUN sh -c 'touch /opt/app.jar'
ENTRYPOINT ["java","-jar","/opt/podcast-server/app.jar"]

# RUN with docker like that :
# $ docker run -it -p 8080:8080 -p 2000:2000 fiodar/td
