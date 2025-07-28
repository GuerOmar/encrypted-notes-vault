# Secure Notes Vault

A secure note-taking application built with Spring Boot, focusing on strong authentication and data protection.

## 🧩 About

This project demonstrates a security-centered design for storing and managing sensitive notes.  
It uses JWT-based authentication with Spring Security to protect access and ensures note contents are safely stored.  
The application implements the Hexagonal Architecture to keep business logic isolated from infrastructure concerns.

- 🚪 **Single entry point:** REST API (secured with JWT)
- 💾 **Single exit point:** Persisting encrypted note data in a PostgreSQL database

## ✨ Features

- 🔑 User registration and login with JWT authentication
- 🔒 Passwords hashed securely with BCrypt
- 🏗️ Clean architecture following Hexagonal principles

## 🛠️ Tech Stack

- ☕ Java 21
- 🌱 Spring Boot
- 🔐 Spring Security with JWT
- 🐘 PostgreSQL


## 🚀 Getting Started

1. 🐳 Run PostgreSQL locally with Docker Compose.
2. ▶️ Build and start the application by running the main class `NotesVaultApplication`.
3. 🌐 Access the REST API at `http://localhost:8080/api`.

## 🔮 Future Improvements

- 🔏 Note content encryption/decryption
