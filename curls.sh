#!/bin/bash
curl -X GET http://localhost:8081/book/1

curl -X POST -H "Content-Type: application/json" -d '{
    "accommodationId": 123,
    "flightId": 456,
    "guest": 2,
    "bookingDate": "2024-03-15T10:00:00",
    "totalAmount": 250.50
}' http://localhost:8081/book

curl -X PUT -H "Content-Type: application/json" -d '{
    "id": 789,
    "accommodationId": 123,
    "flightId": 456,
    "guest": 2,
    "bookingDate": "2024-03-15T10:00:00",
    "totalAmount": 250.50
}' http://localhost:8081/book

curl -X DELETE -H "Content-Type: application/json" -d '{
    "id": 25,
}' http://localhost:8081/book


curl -X GET http://localhost:8082/accommodation/{id}

curl -X GET -H "Content-Type: application/json" -d '{
    "address": {
        "street": "Example Street",
        "city": "Example City",
        "state": "Example State",
        "zipCode": "12345"
    },
    "startPrice": 100.00,
    "endPrice": 200.00
}' http://localhost:8082/accommodation

curl -X POST -H "Content-Type: application/json" -d '{
    "number": 123,
    "addressId": 456,
    "addressStreet": "Example Street",
    "addressCity": "Example City",
    "addressState": "Example State",
    "addressZipCode": "12345",
    "price": 150.00,
    "detail": "Example detail"
}' http://localhost:8082/accommodation

curl -X PUT -H "Content-Type: application/json" -d '{
    "id": 789,
    "number": 123,
    "addressId": 456,
    "addressStreet": "Example Street",
    "addressCity": "Example City",
    "addressState": "Example State",
    "addressZipCode": "12345",
    "price": 150.00,
    "detail": "Updated detail"
}' http://localhost:8082/accommodation


curl -X DELETE -H "Content-Type: application/json" -d '{
    "id": 789,
    "number": 123,
    "addressId": 456,
    "addressStreet": "Example Street",
    "addressCity": "Example City",
    "addressState": "Example State",
    "addressZipCode": "12345",
    "price": 150.00,
    "detail": "Example detail"
}' http://localhost:8082/accommodation


curl -X GET http://localhost:8082/flight/{id}

curl -X GET -H "Content-Type: application/json" -d '{
    "starDeparture": "2024-03-15T10:00:00",
    "endDeparture": "2024-03-15T18:00:00",
    "route": {
        "departureId": 123,
        "departureStreet": "Departure Street",
        "departureCity": "Departure City",
        "departureState": "Departure State",
        "departureZipCode": "12345",
        "arrivalId": 456,
        "arrivalStreet": "Arrival Street",
        "arrivalCity": "Arrival City",
        "arrivalState": "Arrival State",
        "arrivalZipCode": "54321"
    }
}' http://localhost:8082/flight

curl -X POST -H "Content-Type: application/json" -d '{
    "number": 123,
    "departure": "2024-03-15T10:00:00",
    "arrival": "2024-03-15T18:00:00",
    "airlineId": 789,
    "routeId": 101,
    "routeDepartureId": 123,
    "routeDepartureStreet": "Departure Street",
    "routeDepartureCity": "Departure City",
    "routeDepartureState": "Departure State",
    "routeDepartureZipCode": "12345",
    "routeArrivalId": 456,
    "routeArrivalStreet": "Arrival Street",
    "routeArrivalCity": "Arrival City",
    "routeArrivalState": "Arrival State",
    "routeArrivalZipCode": "54321",
    "airlineCompanyName": "Example Airline",
    "airlineCompanyDetails": "Example details"
}' http://localhost:8082/flight

curl -X PUT -H "Content-Type: application/json" -d '{
    "id": 456,
    "number": 123,
    "departure": "2024-03-15T10:00:00",
    "arrival": "2024-03-15T18:00:00",
    "airlineId": 789,
    "routeId": 101,
    "routeDepartureId": 123,
    "routeDepartureStreet": "Departure Street",
    "routeDepartureCity": "Departure City",
    "routeDepartureState": "Departure State",
    "routeDepartureZipCode": "12345",
    "routeArrivalId": 456,
    "routeArrivalStreet": "Arrival Street",
    "routeArrivalCity": "Arrival City",
    "routeArrivalState": "Arrival State",
    "routeArrivalZipCode": "54321",
    "airlineCompanyName": "Updated Airline",
    "airlineCompanyDetails": "Updated details"
}' http://localhost:8082/flight

curl -X DELETE -H "Content-Type: application/json" -d '{
    "id": 456,
    "number": 123,
    "departure": "2024-03-15T10:00:00",
    "arrival": "2024-03-15T18:00:00",
    "airlineId": 789,
    "routeId": 101,
    "routeDepartureId": 123,
    "routeDepartureStreet": "Departure Street",
    "routeDepartureCity": "Departure City",
    "routeDepartureState": "Departure State",
    "routeDepartureZipCode": "12345",
    "routeArrivalId": 456,
    "routeArrivalStreet": "Arrival Street",
    "routeArrivalCity": "Arrival City",
    "routeArrivalState": "Arrival State",
    "routeArrivalZipCode": "54321",
    "airlineCompanyName": "Example Airline",
    "airlineCompanyDetails": "Example details"
}' http://localhost:8082/flight
