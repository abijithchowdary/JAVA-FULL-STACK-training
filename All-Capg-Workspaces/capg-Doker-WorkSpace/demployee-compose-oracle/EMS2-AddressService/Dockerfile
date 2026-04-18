FROM eclipse-temurin:17-jdk
ENV TZ=UTC
WORKDIR /app
COPY target/EMS2-AddressService-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7078
ENTRYPOINT ["java","-jar","app.jar"]