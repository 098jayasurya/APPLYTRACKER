# ApplyTrackr API

ApplyTrackr is a Java Spring Boot REST API for tracking internship and job applications. It helps students organize companies, roles, locations, deadlines, notes, and interview status in one backend service.

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- H2 Database
- Bean Validation
- Swagger/OpenAPI
- Maven

## Features

- Create, view, search, and delete job applications
- Filter applications by status
- Update application status with a dedicated endpoint
- DTO-based request validation
- Global exception handling
- H2 in-memory database with sample data
- Swagger UI API documentation

## Run Locally

```bash
mvn spring-boot:run
```

Open:

- Swagger UI: `http://localhost:8080/swagger-ui.html`
- H2 Console: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:applytrackr`

## Docker

```bash
docker build -t applytrackr-api .
docker run -p 8080:8080 applytrackr-api
```

## API Endpoints

| Method | Endpoint | Description |
| --- | --- | --- |
| POST | `/api/applications` | Create an application |
| GET | `/api/applications` | List all applications |
| GET | `/api/applications/{id}` | Get one application |
| GET | `/api/applications/status/{status}` | Filter by status |
| GET | `/api/applications/search?keyword=java` | Search company or role |
| PATCH | `/api/applications/{id}/status` | Update status |
| DELETE | `/api/applications/{id}` | Delete application |

## Sample Request

```json
{
  "companyName": "Stripe",
  "role": "Java Backend Intern",
  "location": "Remote",
  "status": "APPLIED",
  "applicationDate": "2026-07-25",
  "deadline": "2026-08-10",
  "notes": "Applied through careers page."
}
```

## Status Values

`APPLIED`, `INTERVIEW`, `OFFER`, `REJECTED`, `WITHDRAWN`

## Resume Bullets

- Built a Java Spring Boot REST API for tracking internship and job applications with CRUD operations, status filtering, and search functionality.
- Designed a layered backend architecture using Controller-Service-Repository pattern with JPA, DTO validation, and centralized exception handling.
- Documented REST endpoints using Swagger/OpenAPI and configured H2 database seed data for fast local demos.

## Future Improvements

- Add JWT authentication
- Add PostgreSQL profile for deployment
- Add email reminders for follow-ups
- Add React dashboard
- Add unit and integration tests
