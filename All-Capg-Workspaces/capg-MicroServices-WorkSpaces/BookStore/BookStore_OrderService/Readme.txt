port: 8082

GET
getallorders
localhost:8082/api/orders

GET
getorderbyid
localhost:8082/api/orders/1

POST
placeorder
localhost:8082/api/orders

{
"bookId": 1,
"customerName": "Alice",
"quantity": 2
}

Response Example

{
"id": 1,
"bookId": 1,
"customerName": "Alice",
"quantity": 2,
"totalPrice": 999.98,
"status": "PLACED",
"orderDate": "2026-03-15"
}

PUT
updateorderstatus
localhost:8082/api/orders/1

{
"status": "SHIPPED"
}

DELETE
deleteorder
localhost:8082/api/orders/1
