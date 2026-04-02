# Hotel Reservation System

Spring Boot REST API for managing hotel rooms and reservations with PostgreSQL.

## Tech Stack

- Java 17
- Spring Boot 3.2
- Spring Data JPA
- PostgreSQL
- Maven

## Setup

**1. Create database:**
```sql
CREATE DATABASE hotel_db;
```

**2. Update `application.properties`:**
```properties
spring.datasource.username=your_username
spring.datasource.password=your_password
```

**3. Run:**
```bash
mvn spring-boot:run
```

## API Endpoints

### Rooms
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/rooms` | Get all rooms |
| GET | `/api/rooms/available` | Get available rooms |
| GET | `/api/rooms/{roomNumber}` | Get room by number |
| POST | `/api/rooms` | Add new room |

### Reservations
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/reservations` | Get all reservations |
| GET | `/api/reservations/{id}` | Get reservation by ID |
| POST | `/api/reservations` | Create reservation |
| DELETE | `/api/reservations/{id}` | Cancel reservation |

## Examples

**Add a room:**
```json
POST /api/rooms
{
  "roomNumber": 101,
  "type": "Single",
  "pricePerNight": 35.0
}
```

**Create a reservation:**
```json
POST /api/reservations
{
  "roomNumber": 101,
  "fullName": "Ali Valiyev",
  "phoneNumber": "+998901234567",
  "nights": 3
}
```

## Error Responses

| Status | Meaning |
|--------|---------|
| 400 | Validation error |
| 404 | Room or reservation not found |
| 409 | Room is not available |
| 500 | Internal server error |
