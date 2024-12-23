# Movie Booking System Backend

This is the backend for a **Movie Booking System** where users can book and reserve seats for various movie shows. The system also supports multiple languages for the movies. Built using **Spring Boot** with **PostgreSQL** for data storage, and includes **Swagger UI** for API documentation.

## Features

- **Book and Reserve Seats**: Users can select and book seats for available shows.
- **Show Details**: Provides information about movies, available shows, and languages.
- **Multi-Language Support**: Movies are available in different languages.
- **Swagger UI**: Interactive API documentation for easy testing of the system's endpoints.

## Technologies Used

- **Spring Boot**: For backend development.
- **PostgreSQL**: For database management.
- **Swagger UI**: For API documentation and testing.
- **Spring Data JPA**: To interact with the PostgreSQL database.

## Installation

### Prerequisites

Make sure you have the following installed:

- JDK 11 or higher
- PostgreSQL database
- Maven or Gradle for dependency management

### Steps to Run Locally

1. **Clone the Repository**:
   ```bash
   git clone git@github.com:Tusharr06/MOVIE-TICKET-BOOKING.git
   cd MOVIE-TICKET-BOOKING
   ```

2. **Setup PostgreSQL**:
   - Create a database in PostgreSQL for the project.
   - Update your `application.properties` or `application.yml` file with your database credentials:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/movie_booking
     spring.datasource.username=<your-username>
     spring.datasource.password=<your-password>
     spring.jpa.hibernate.ddl-auto=update
     ```

3. **Run the Application**:
   - If you're using Maven:
     ```bash
     mvn spring-boot:run
     ```
   The application should now be running locally on port `8080` by default.

## API Documentation (Swagger UI)

Once the backend is running, you can access the **Swagger UI** by visiting:
```
http://localhost:8080/swagger-ui/index.html#/
```

Swagger UI allows you to interact with the available API endpoints, view request/response details, and test various functionalities like booking tickets, reserving seats, and fetching available shows.

## Endpoints

Here is a quick overview of some of the key API endpoints:

- **GET** `/api/movies` - Get the list of all movies.
- **GET** `/api/shows` - Get the list of all available shows.
- **POST** `/api/bookings` - Book a seat for a specific show.
- **GET** `/api/bookings/{id}` - Get booking details by booking ID.

### Sample Request

```json
{
  "movieId": 1,
  "showId": 2,
  "seats": ["A1", "A2"],
  "language": "English"
}
```

### Sample Response

```json
{
  "bookingId": 12345,
  "status": "success",
  "message": "Seats successfully booked!"
}
```

## Screenshots

Here are some screenshots of the system in action:

 ![API Documentation](https://github.com/Tusharr06/MOVIE-TICKET-BOOKING/blob/e1702921baf24b241e73e4fb4e09ca3bbad981c4/images/Screenshot%20from%202024-12-23%2013-24-49.png)
 ![Booking Screen](https://github.com/Tusharr06/MOVIE-TICKET-BOOKING/blob/e1702921baf24b241e73e4fb4e09ca3bbad981c4/images/Screenshot%20from%202024-12-23%2013-26-50.png)
 ![Seat Reservation](https://github.com/Tusharr06/MOVIE-TICKET-BOOKING/blob/e1702921baf24b241e73e4fb4e09ca3bbad981c4/images/Screenshot%20from%202024-12-23%2013-26-57.png)

## Contributing

Feel free to fork the repository and submit pull requests if you'd like to contribute to the project.
