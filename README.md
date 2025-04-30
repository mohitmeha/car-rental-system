# car-rental-system
A complete Car Rental System built with Spring Boot and MongoDB. Includes features like car listing, booking, soft delete, and search, with Swagger integration for API testing.

# 🚗 Car Rental Service

A full-featured **Car Rental System** built with **Spring Boot** and **MongoDB**, offering car listings, bookings, and user-friendly API interactions via Swagger UI.

## 📌 Features

- Add, update, soft delete cars
- Book cars using date range
- View bookings by car or customer
- MongoDB Atlas integration
- Swagger UI for API testing
- DTO-based request/response handling

## 🛠 Tech Stack

- **Java 17+**
- **Spring Boot**
- **MongoDB Atlas**
- **Swagger (SpringDoc OpenAPI)**
- **Lombok** for boilerplate code

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven or Gradle
- MongoDB Atlas URI

### Clone & Configure

```bash
git clone https://github.com/yourusername/car-rental-system.git
cd car-rental-system
Update application.properties:

properties
Copy
Edit
spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster-url/car_rental_db
Run the App
bash
Copy
Edit
./mvnw spring-boot:run
Swagger UI
Visit:

bash
Copy
Edit
http://localhost:8080/swagger-ui.html
🧾 Sample BookingRequest Payload
json
Copy
Edit
{
  "carId": "662f18d9eabf123abc456def",
  "customerName": "John Doe",
  "startDate": "2025-05-01",
  "endDate": "2025-05-05"
}
📂 Project Structure
pgsql
Copy
Edit
car-rental-system/
├── controller/
│   └── CarController.java
│   └── BookingController.java
├── dto/
│   └── BookingRequest.java
├── model/
│   └── Car.java
│   └── Booking.java
├── repository/
│   └── CarRepository.java
│   └── BookingRepository.java
├── service/
│   └── CarService.java
│   └── BookingService.java
├── exception/
│   └── GlobalExceptionHandler.java
├── CarRentalSystemApplication.java
🔌 API Endpoints

Method	Endpoint	Description:-
POST	/api/cars	Add a new car
GET	/api/cars	List all cars
GET/api/car/search serach car
DELETE	/api/cars/{id}	Soft delete a car

POST	/api/bookings	Create a booking
GET	/api/bookings	List all bookings
GET	/api/booking/return/{BookingId} return a booking car
