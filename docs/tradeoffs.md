# Salary Management System - Tradeoffs and Performance Considerations

## Technology Choices

### Spring Boot

Spring Boot was selected because it provides a clear structure for REST APIs, dependency injection and database integration.

### PostgreSQL

PostgreSQL was selected because the application requires relational data and relationships between employees and salaries.

### Angular

Angular was selected for the frontend because it provides a structured component-based approach suitable for an enterprise-style application.

## Pagination

The employee API uses pagination rather than returning all 10,000 employees in a single response.

This reduces the amount of data transferred to the browser and improves initial page performance.

## Current Filtering Approach

Country and department filtering is currently performed on the employees already loaded into the frontend page.

### Advantage

- Simple implementation
- Immediate filtering
- Easy to understand

### Tradeoff

The filter currently applies only to the loaded page rather than all 10,000 employees.

For production, filtering should be implemented in the backend using database queries and indexed columns.

## Salary Loading

The current frontend requests salary information for each displayed employee.

### Advantage

- Simple API design
- Easy to implement and understand

### Tradeoff

This can result in multiple HTTP requests.

For a production implementation, salary data could be returned using a join/projection or a dedicated paginated endpoint to reduce the number of requests.

## Data Seeding

Development data is seeded automatically to provide a realistic dataset for testing.

The current seeding implementation uses individual repository saves.

For a larger dataset, batch inserts would improve startup performance.

## Database Validation

Hibernate is configured with:

`ddl-auto=validate`

This allows Hibernate to validate the entity mappings against the existing database schema instead of automatically modifying the schema.

Flyway is responsible for database migrations.

## Maintainability

The backend is separated into:

- Controller
- Service
- Repository
- Entity
- DTO

This separation keeps responsibilities clear and makes the code easier to test and maintain.