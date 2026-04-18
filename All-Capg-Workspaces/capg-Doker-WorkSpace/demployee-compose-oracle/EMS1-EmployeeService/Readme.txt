without docker compose:

mvn clean package -DskipTests
docker build -t ems1employee_service .
docker run -p 7071:7071 ems1employee_service


post: http://localhost:7071/employees

{
        "id":101,
        "name":"sanjana",
        "email":"sanjana@gmail.com"
    }
    
get: http://localhost:7071/employees