# Jak uruchomić program

`mvn spring-boot:run`

Wszystkie ścieżki zaczynają się od localhost:8080

Headers: Content-Type application/json

1. GET: /cats

* odpowiedź: pusta tablica

2. POST: /cats

ciało zapytania:

{
	"name":"Cat name",
	"age":5,
	"color":"BLACK"
}

* odpowiedź:

{
    "timestamp": "2020-01-09T22:00:26.797+0000",
    "status": 400,
    "error": "Bad Request",
    "message": "You have too small group of zookeepers.",
    "path": "/cats"
}

3. POST: /zookeepers

ciało zapytania:
{
	"name": "Name",
	"surname": "Surname"
}

* odpowiedź : Successfully added zookeeper!

Powtórz krok 2.

* odpowiedź : Successfully added kitty

Powtórz krok 1.

* odpowiedź :

[
    {
        "id": 2,
        "name": "Cat name",
        "age": 5,
        "color": "BLACK",
        "zookeeperName": "Name"
    }
]



