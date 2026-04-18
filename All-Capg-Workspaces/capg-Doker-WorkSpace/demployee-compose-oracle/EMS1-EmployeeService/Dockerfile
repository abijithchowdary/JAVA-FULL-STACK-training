FROM eclipse-temurin:17-jdk
ENV TZ=UTC
WORKDIR /app
COPY target/EMS1-EmployeeService-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 7079
ENTRYPOINT ["java","-jar","app.jar"]