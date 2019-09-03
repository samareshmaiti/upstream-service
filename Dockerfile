FROM openjdk:11
ADD ./target/upstream-service-0.0.1-SNAPSHOT.jar /usr/src/upstream-service-0.0.1-SNAPSHOT.jar
EXPOSE 8091
WORKDIR usr/src
ENTRYPOINT ["java","-jar","upstream-service-0.0.1-SNAPSHOT.jar"]