# Mini Redis - Java

A lightweight Redis-like in-memory key-value database built from scratch in Java.

## 🚀 Features

- In-memory key-value storage
- SET / GET / DEL / EXISTS commands
- TTL-based key expiration
- SETEX command
- TCP socket server
- Multiple client support
- Command-line Redis client
- Spring Boot REST API
- CORS-enabled production API
- Web dashboard
- Automated unit tests
- Logging and error handling
- Public frontend and backend deployment

## 🛠️ Tech Stack

- Java 21
- Spring Boot
- Maven
- REST API
- TCP Sockets
- HTML
- CSS
- JavaScript
- JUnit
- Git & GitHub
- Railway
- Netlify

## 🏗️ Architecture

```text
Web Dashboard
      |
      v
Spring Boot REST API
      |
      v
KeyValueStore
      |
      v
In-Memory HashMap

The project also includes a TCP-based Redis server and command-line client.

📡 REST API
SET
POST /api/set?key=name&value=Devesh
GET
GET /api/get?key=name
SETEX
POST /api/setex?key=temp&seconds=10&value=Hello
DELETE
DELETE /api/delete?key=name
EXISTS
GET /api/exists?key=name
⏱️ TTL Support

Keys can be stored with an expiration time using SETEX.

Example:

SETEX temp 10 Hello

After 10 seconds, the key becomes unavailable.

🧪 Testing

The project includes tests for:

Key-value storage
Command handling
SET / GET operations
DELETE
EXISTS
TTL behavior
🌐 Live Demo

Frontend:
https://candid-haupia-3c2d34.netlify.app/

Backend:
https://miniredis-java-production.up.railway.app/

📂 Project Structure
MiniRedis-Java/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── miniredis/
│   └── test/
├── frontend/
│   ├── index.html
│   ├── style.css
│   └── script.js
├── pom.xml
└── README.md
🎯 Purpose

This project was built to understand how an in-memory database works internally, including data storage, command processing, TTL expiration, TCP networking, REST APIs, frontend-backend communication, testing, and deployment.

👨‍💻 Author

Devesh