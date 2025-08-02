# Doctor Booking API

Simple Spring Boot backend for managing doctors and appointments with MySQL.

## Tech Stack
- Java 21  
- Spring Boot 3.x  
- Spring Data JPA / Hibernate  
- MySQL  
- Maven  
- Jakarta Validation (`@Valid`)  
- Lombok (optional, for boilerplate reduction)  
- RESTful APIs  

## API Endpoints

### Doctor Endpoints
| Method | Endpoint              | Description             |
|--------|-----------------------|-------------------------|
| POST   | `/doctors`            | Create a new doctor      |
| GET    | `/doctors`            | Get all doctors          |
| GET    | `/doctors/{id}`       | Get a doctor by ID       |
| PUT    | `/doctors/{id}`       | Update a doctor          |
| DELETE | `/doctors/{id}`       | Delete a doctor          |

### Appointment Endpoints
| Method | Endpoint                                  | Description                             |
|--------|-------------------------------------------|-----------------------------------------|
| POST   | `/appointments/doctor/{doctorId}`          | Create appointment for a doctor          |
| GET    | `/appointments`                           | Get all appointments                    |
| GET    | `/appointments/{id}`                      | Get appointment by ID                   |
| GET    | `/appointments/doctor/{doctorId}`          | Get all appointments for a specific doctor |
| PUT    | `/appointments/{id}`                      | Update an appointment                  |
| DELETE | `/appointments/{id}`                      | Delete an appointment                  |

## Sample JSON

### Doctor (for create / update)
```json
{
  "name": "Dr. Ramesh Kumar",
  "specialization": "Cardiologist",
  "contact": "+91-9876543210"
}
### Appointments (for create / update)
```json
{
  "patientName": "Amit Sharma",
  "appointmentTime": "2025-08-10T14:30:00",
  "reason": "Chest pain evaluation",
  "status": "SCHEDULED"
}

