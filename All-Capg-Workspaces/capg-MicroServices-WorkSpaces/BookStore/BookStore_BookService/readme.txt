port: 8081

getallbooks
localhost:8081/books/getall
getbookbyid
localhost:8081/books/getbook/1
addbook
localhost:8081/books/add
{
	"title":"Clean Code",
	"author":"Josph Martin",
	"isbn":"978-0132350884",
	"price":499.99,
	"quantity":20,
	"category":"Optical Trading"
}

updatebook
localhost:8081/books/update/1
{{
	"title":"Java Core",
	"author":"Layana Jackson",
	"isbn":"978-0132350884",
	"price":469.99,
	"quantity":10,
	"category":"Fundamentas in a Trade"
}

deletebook
localhost:8081/books/delete/1