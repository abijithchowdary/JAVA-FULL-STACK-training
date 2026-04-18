go to EMS1-EmployeeService

mvn clean package -DskipTests

go to EMS2-AddressService

mvn clean package -DskipTests

go to the demployee-compose-oracle (main folder)
docker compose up --build

post: http://localhost:7071/employees

{
        "id":102,
        "name":"Diksha",
        "email":"Diksha@gmail.com"
    }
    
get: http://localhost:7071/employees


post : http://localhost:7072/address

{
"id":101,
"state":"Himachal Pradesh",
"city":"shimla",
"pincode":144411
}

get: http://localhost:7072/address
