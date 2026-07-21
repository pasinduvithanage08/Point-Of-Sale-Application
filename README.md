# 🛒 POS System — Backend API

A backend REST API for a Point of Sale (POS) system built with **Spring Boot**. The application handles core POS operations including product management, customer management, order processing, and sales reporting. All endpoints are documented and testable via **Swagger UI**.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java |
| Framework | Spring Boot |
| Build Tool | Maven / Gradle |
| IDE | IntelliJ IDEA |
| API Docs | Swagger UI (SpringDoc OpenAPI) |
| Database | MySQL / PostgreSQL |
| ORM | Spring Data JPA (Hibernate) |

---

## ✅ Prerequisites

Make sure the following are installed before running the project:

- Java JDK 17 or higher
- Maven 3.x or Gradle 7.x
- MySQL or PostgreSQL database server
- IntelliJ IDEA (recommended)
- Git

---

## ⚙️ Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### 2. Configure the Database

Open `src/main/resources/application.properties` (or `application.yml`) and update the database credentials:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/pos_db
spring.datasource.username=your_db_username
spring.datasource.password=your_db_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Create the database manually if it does not exist:

```sql
CREATE DATABASE pos_db;
```

### 3. Build the Project

**Using Maven:**
```bash
mvn clean install
```

**Using Gradle:**
```bash
./gradlew build
```

### 4. Run the Application

**Using Maven:**
```bash
mvn spring-boot:run
```

**Using Gradle:**
```bash
./gradlew bootRun
```

**Or run the JAR directly:**
```bash
java -jar target/pos-system-0.0.1-SNAPSHOT.jar
```

The application will start on **`http://localhost:8080`** by default.

---

## 📖 API Documentation (Swagger UI)

Once the application is running, open your browser and navigate to:

```
http://localhost:8080/swagger-ui/index.html
```

All available REST endpoints are listed there. You can test each endpoint directly from the browser — no additional tools required.

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/yourpackage/pos/
│   │       ├── controller/       # REST controllers
│   │       ├── service/          # Business logic layer
│   │       ├── repository/       # Spring Data JPA repositories
│   │       ├── model/            # Entity classes
│   │       ├── dto/              # Data Transfer Objects
│   │       └── PosApplication.java
│   └── resources/
│       ├── application.properties
│       └── static/
└── test/
    └── java/                     # Unit & integration tests
```

---

## 🔑 Key API Endpoints

> Full details with request/response schemas are available in Swagger UI.

| Resource | Endpoint | Method | Description |
|---|---|---|---|
| Products | `/api/products` | GET | Get all products |
| Products | `/api/products` | POST | Add new product |
| Products | `/api/products/{id}` | PUT | Update product |
| Products | `/api/products/{id}` | DELETE | Delete product |
| Customers | `/api/customers` | GET | Get all customers |
| Customers | `/api/customers` | POST | Add new customer |
| Orders | `/api/orders` | GET | Get all orders |
| Orders | `/api/orders` | POST | Place a new order |
| Orders | `/api/orders/{id}` | GET | Get order by ID |

---

## 🧪 Testing

All endpoints were tested using **Swagger UI**. You can also import the API into **Postman** using the OpenAPI JSON:

```
http://localhost:8080/v3/api-docs
```

---

## 🚀 Deployment

To build a production-ready JAR:

```bash
mvn clean package -DskipTests
```

The output JAR will be in the `target/` directory. Deploy it to any server with Java installed using:

```bash
java -jar target/pos-system-0.0.1-SNAPSHOT.jar
```

---

## 👨‍💻 Author

**Pasindu**  
HNDIT Student — Advanced Technological Institute, Anuradhapura (SLIATE)  
Industrial Training — Spring Boot Academy (Pvt) Ltd, Moratuwa

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
