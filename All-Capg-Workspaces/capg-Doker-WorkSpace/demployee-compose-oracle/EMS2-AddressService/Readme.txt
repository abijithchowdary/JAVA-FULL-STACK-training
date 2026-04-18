without docker compose:


mvn clean package -DskipTests
docker build -t ems2address_service .
docker run -p 7072:7072 ems2address_service


post : http://localhost:7072/address

{
"id":101,
"state":"Himachal Pradesh",
"city":"shimla",
"pincode":144411
}

get: http://localhost:7072/address