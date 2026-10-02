# Mini Redis - Java

A lightweight Redis-like in-memory key-value store built from scratch in Java.

## Features

- In-memory key-value storage
- SET command
- GET command
- DEL command
- EXISTS command
- PING command
- SETEX with TTL expiration
- TCP socket server
- Multiple client connections
- Java command-line client
- Spring Boot REST API
- Web dashboard
- Request logging
- Input validation
- Automated JUnit tests

## Technology Stack

- Java 21
- Maven
- Spring Boot
- REST API
- HTML
- CSS
- JavaScript
- JUnit 5
- TCP Sockets
- Git & GitHub

## Project Structure

```text
MiniRedis-Java
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── miniredis
│   │               ├── KeyValueStore.java
│   │               ├── CommandHandler.java
│   │               ├── RedisServer.java
│   │               ├── RedisClient.java
│   │               ├── MiniRedisApplication.java
│   │               └── RedisController.java
│   │
│   └── test
│       └── java
│           └── com
│               └── miniredis
│                   ├── KeyValueStoreTest.java
│                   └── CommandHandlerTest.java
│
├── frontend
│   ├── index.html
│   ├── style.css
│   └── script.js
│
├── pom.xml
├── .gitignore
└── README.md

## Redis Commands

### SET

Stores a value.

```text
SET name Devesh

GET

Retrieves a value.

GET name
DEL

Deletes a key.

DEL name
EXISTS

Checks whether a key exists.

EXISTS name
PING

Checks whether the server is responding.

PING
SETEX

Stores a value with an expiration time.

SETEX temporary 10 Hello

The key expires after 10 seconds.

Running the Backend

Run:

MiniRedisApplication

The Spring Boot API starts on:

http://localhost:8080
REST API
GET
GET /api/get?key=name
SET
POST /api/set?key=name&value=Devesh
SETEX
POST /api/setex?key=name&seconds=30&value=Devesh
DELETE
DELETE /api/delete?key=name
EXISTS
GET /api/exists?key=name
Running the TCP Server

Run:

RedisServer

The TCP server listens on port:

6379

Then run:

RedisClient
Testing

The project includes automated JUnit tests for:

SET and GET
DELETE
EXISTS
Missing keys
TTL expiration
Command handling
PING
SETEX

Run all tests from IntelliJ IDEA.

Architecture
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

The project also includes a TCP server:

Redis Client
     |
     v
TCP Socket Server
     |
     v
Command Handler
     |
     v
KeyValueStore
Purpose

This project demonstrates the core concepts behind an in-memory key-value database and provides practical experience with:

Java
Networking
TCP sockets
REST APIs
Backend development
Frontend integration
Concurrency
TTL-based expiration
Automated testing
Logging
Software architecture
Author

Devesh
