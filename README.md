# Role-Based Access Control (RBAC) System

## Internship Information

- **Internship Organization:** CODTECH
- **Intern ID:** CITS9357
- **Project Title:** Role-Based Access Control (RBAC) System
- **Technology:** Java, Spring Boot, Spring Security, JWT, MySQL

## Project Overview

The Role-Based Access Control (RBAC) System is a backend application developed using Java and Spring Boot to manage authentication and authorization based on user roles.

The system uses JSON Web Tokens (JWT) for authentication and role-based authorization to control access to protected API endpoints. Different roles, such as USER, MANAGER, and ADMIN, have different levels of access.

## Features

- User authentication using JWT.
- Role-based authorization.
- Protected REST API endpoints.
- User profile access.
- Manager dashboard access.
- Admin dashboard access.
- User management endpoints for administrators.
- MySQL database integration.
- Spring Data JPA and Hibernate for database operations.
- Environment-variable-based configuration for sensitive credentials.

## Technologies Used

- **Programming Language:** Java
- **Backend Framework:** Spring Boot
- **Security:** Spring Security
- **Authentication:** JSON Web Token (JWT)
- **Database:** MySQL
- **ORM:** Spring Data JPA and Hibernate
- **Build Tool:** Maven
- **API Testing:** Postman
- **Version Control:** Git and GitHub

## Role Permissions

| Role | Permissions |
|---|---|
| USER | Access the user profile |
| MANAGER | Access the user profile and manager dashboard |
| ADMIN | Access the user profile, manager dashboard, admin dashboard, and user-management endpoints |

## API Endpoints

| HTTP Method | Endpoint | Access |
|---|---|---|
| GET | `/api/user/profile` | USER, MANAGER, ADMIN |
| GET | `/api/manager/dashboard` | MANAGER, ADMIN |
| GET | `/api/admin/dashboard` | ADMIN |
| GET | `/api/users` | ADMIN |
| GET | `/api/users/{id}` | ADMIN |

All protected endpoints require a valid JWT unless the application's security configuration specifies otherwise.

## Prerequisites

Install the following before running the project:

- Java Development Kit (JDK)
- MySQL Server
- Git
- Postman (optional, for API testing)

## Database Configuration

Create the database in MySQL:

```sql
CREATE DATABASE rbac_db;
```

Configure the following environment variables before running the application:

- `DB_URL` — JDBC URL for the MySQL database
- `DB_USERNAME` — MySQL username
- `DB_PASSWORD` — MySQL password
- `JWT_SECRET` — Secret used to sign JWTs
- `JWT_EXPIRATION` — Token expiration in milliseconds (optional; defaults to 86400000)
- `PORT` — Server port (optional; defaults to 8080)

Do not commit actual database passwords or JWT secrets to GitHub.

## Running the Project

**1. Clone the repository**

```bash
git clone https://github.com/Syedasif689/Rolebaseaccess.git
cd Rolebaseaccess
```

**2. Configure your environment variables**

Set the database credentials and JWT secret in your operating system or development environment.

**3. Build the project**

On Windows PowerShell:

```powershell
.\mvnw clean compile
```

**4. Start the application**

```powershell
.\mvnw spring-boot:run
```

The application runs on `http://localhost:8080` by default.

## Testing

Use Postman to test the API endpoints.

1. Authenticate and obtain a JWT using the application's configured login endpoint.
2. Select **Authorization → Bearer Token**.
3. Enter the JWT.
4. Send requests to the protected endpoints.
5. Verify that unauthorized roles cannot access restricted resources.

Expected responses include:

- `200 OK` — The request is authorized and succeeds.
- `401 Unauthorized` — Authentication is missing or invalid.
- `403 Forbidden` — The authenticated user does not have the required role.

## Security Notes

- Store database credentials and JWT secrets in environment variables.
- Never commit real secrets or passwords to version control.
- Avoid returning password hashes or other sensitive information from user-management endpoints.
- Use HTTPS and a strong, securely generated JWT signing secret in production.
- Ensure method-level security is enabled for `@PreAuthorize` annotations.

## Learning Outcomes

Through this project, I gained practical experience with:

- Spring Boot REST API development.
- Authentication and authorization.
- JWT-based security.
- Role-based access control.
- MySQL database integration.
- API testing using Postman.
- Secure configuration and GitHub version control.

## Author

**Developed as part of the CODTECH Internship Program**

- **Intern