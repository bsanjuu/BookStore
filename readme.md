




# BookStore Microservices App


A full-stack BookStore application built using:

- **Spring Boot** for backend services
- **Apache Kafka** for event-driven communication
- **PostgreSQL** for persistent storage
- **React** for the frontend
- **Docker Compose** to run everything together

---

##  Features

-  Add books to the store
-  Purchase books (simulated)
-  Kafka-based notifications for add/purchase events
-  Email alerts to users when events happen
-  React UI to view available books
-  PostgreSQL for persistence
-  Dockerized environment

---

## ️ Tech Stack

| Layer        | Tech                     |
|-------------|--------------------------|
| Backend API | Spring Boot (Java 17)    |
| Messaging   | Apache Kafka             |
| Database    | PostgreSQL               |
| Frontend    | React.js                 |
| Mail        | Spring Mail (Gmail SMTP) |
| Container   | Docker, Docker Compose   |

---

##  Directory Structure

```
BookStore/
├── Backend/          # Spring Boot app
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml
├── frontend/         # React app
│   ├── src/
│   ├── Dockerfile
│   └── package.json
├── docker-compose.yml
└── README.md
```

---

##  Running the App Locally (With Docker)

> Make sure Docker is installed and running on your system.

### 1. Clone the repo

```bash
git clone https://github.com/your-username/BookStore.git
cd BookStore
```

### 2. Build & Run All Services

```bash
docker-compose up --build
```

### 3. Access the App

- 🔗 **Frontend**: [http://localhost:3000](http://localhost:3000)
- 🔗 **Backend API**: [http://localhost:8080/books](http://localhost:8080/books)
- 🐘 **Postgres**: `localhost:5432` (user: `postgres`, pass: `2324`)
- ⚡ **Kafka**: `localhost:9092`

---

##  Sample API Usage

###  Add a New Book

```http
POST /books
Content-Type: application/json

{
  "title": "Kafka in Action",
  "author": "John Doe",
  "price": 29.99
}
```

###  Purchase a Book

```http
POST /books/1/purchase
```

Triggers Kafka `[PURCHASE]` event and sends email notification.

---

## Email Setup

To use email notifications:

- Configure your Gmail SMTP in `Backend/src/main/resources/application.properties`
- Example:

```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

## To Do

- [ ] Add UI for purchasing books
- [ ] Store user emails and notify specific users
- [ ] Add authentication (Google Sign-In is preconfigured)
- [ ] Deploy to Railway or AWS

---

##  Feedback & Contributions

Feel free to fork the repo, open issues, or submit PRs!


