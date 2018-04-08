FROM java:8
VOLUME /tmp
VOLUME /opt/podcast-server
ADD task-delivery.jar /opt/podcast-server/task-delivery.jar
RUN sh -c 'touch /opt/task-delivery.jar'
ENTRYPOINT ["java","-jar","/opt/podcast-server/task-delivery.jar"]