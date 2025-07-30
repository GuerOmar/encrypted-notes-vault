# Secure Notes Vault

I was curious and wanted to dive deeper into topics like secure credential storage, encryption at rest and stateless authentication. This led me to explore areas such as JWT-based authentication, password hashing and AES-GCM encryption for protecting data.

## 🧩 About
A secure note application built with Spring Boot focusing on strong authentication and data protection. 

It uses JWT-based authentication with Spring Security to protect access and ensures note contents are safely stored.  

The application implements the Hexagonal Architecture to keep business logic isolated from infrastructure concerns.

- 🚪 **Single entry point:** REST API (secured with JWT)
- 💾 **Single exit point:** Persisting encrypted note data in a PostgreSQL database

This project was built as a learning experience so certain security related features were implemented manually to better understand how they work under the hood. Also the AES encryption key is currently hardcoded for simplicity and should ideally be managed securely using an external secrets manager.

## ✨ Features

- 🔑 User registration and login with JWT authentication
- 🔒 Passwords hashed securely with BCrypt
- 🔏 Note content encryption/decryption
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