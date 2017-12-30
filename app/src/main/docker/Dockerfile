FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
VOLUME /opt/podcast-server
ADD app.jar /opt/podcast-server/app.jar
RUN sh -c 'touch /opt/app.jar'
ENTRYPOINT ["java","-jar","/opt/podcast-server/app.jar"]

# RUN with docker like that :
# $ docker run -it -p 127.0.0.15:8080 fiodar/td
# docker run --network="taskdelivery_default" fiodar/td
# docker run --network="host" -id <Docker image ID>