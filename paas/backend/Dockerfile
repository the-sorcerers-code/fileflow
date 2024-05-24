FROM maven:3.8.6-amazoncorretto-19 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app

# Compile and package the application to an executable JAR
RUN mvn -DskipTests=true package

# For Java 19,
FROM amazoncorretto:19

ARG JAR_FILE=backend-0.0.1-SNAPSHOT.jar

WORKDIR /opt/app

COPY --from=maven /usr/src/app/target/${JAR_FILE} /opt/app

EXPOSE 8285


ENTRYPOINT ["java","-jar", "-agentlib:jdwp=transport=dt_socket,address=*:5005,server=y,suspend=n", "-Djava.net.preferIPv4Stack=true", "backend-0.0.1-SNAPSHOT.jar"]