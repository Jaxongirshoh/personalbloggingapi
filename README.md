# PersonalBlogging API

The **PersonalBlogging API** is a RESTful web service built with **Spring Boot** for managing blog posts. This API allows you to create, read, update, and delete blog posts, as well as search posts by a term (e.g., title or content).

## Features
- **Create** new blog posts with title, content, category, and tags
- **Read** posts by ID
- **Update** existing posts
- **Delete** posts
- **Search** posts by term (e.g., `GET /posts?term=tech`)
- **Category Management** for organizing posts
- **Tag Support** for better content classification

## Technologies Used
- **Java 21** (using GraalVM toolchain)
- **Spring Boot 3.4.1**
- **Spring Data JPA** for database interaction
- **PostgreSQL** for persistence
- **Lombok** for reducing boilerplate code
- **Spring Boot Actuator** for monitoring and metrics
- **JUnit** for testing

## Prerequisites
- Java 21 or higher
- Gradle for building the project
- PostgreSQL database server
- GraalVM (optional, for native builds)

## Setup

### Clone the Repository
```bash
git clone https://github.com/Jaxongirshoh/personalbloggingapi.git
cd personalbloggingapi
```

### Configure Database
Create a `application.properties` file in `src/main/resources`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Build and Run
```bash
./gradlew build
./gradlew bootRun
```

For native builds (requires GraalVM):
```bash
./gradlew nativeCompile
```

## API Endpoints

### Posts
- `POST /posts` - Create a new post
- `GET /posts/{id}` - Get a post by ID
- `GET /posts` - List all posts (with optional search term)
- `PUT /posts/{id}` - Update a post
- `DELETE /posts/{id}` - Delete a post

### Request/Response Examples

#### Create Post
```json
POST /posts
{
    "title": "Understanding Spring Boot",
    "content": "Spring Boot simplifies Java development...",
    "category": "Java",
    "tags": ["Spring", "Java", "Boot"]
}
```

## Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── dev/
│   │       └── wisespirit/
│   │           └── personalbloggingapi/
│   └── resources/
│       └── application.properties
└── test/
    └── java/
```

## Dependencies
- Spring Boot Starter Web
- Spring Boot Starter Data JPA
- Spring Boot Starter Actuator
- PostgreSQL Driver
- Lombok
- JUnit for testing

## Contributing
1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a Pull Request

## Build Information
- Build System: Gradle
- Group ID: dev.wisespirit
- Version: 0.0.1-SNAPSHOT
- Java Version: 21
- Spring Boot Version: 3.4.1
- Hibernate ORM Version: 6.6.4.Final

## License
[Add your license information here]