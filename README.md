# 🛍️ E-Commerce Backend

This is the backend service for an E-Commerce web application.  
It is built using **Spring Boot**, **Spring Data JPA**, and **MySQL** to provide REST APIs for managing products, categories, and images.  

---

## 🚀 Features
- Product CRUD (Create, Read, Update, Delete)
- Upload and retrieve product images
- Category and brand management
- REST API design with Spring Boot
- Database integration with MySQL
- Cross-origin support for frontend integration

---

## 🛠️ Tech Stack
- **Java 17+**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **MySQL Database**
- **Maven**
- **Lombok**
- **REST APIs**

---

## ⚙️ Project Setup

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/Khshaikh-19/ecom-backend.git
cd ecom-backend
CREATE DATABASE ecom_db;
spring.datasource.url=jdbc:mysql://localhost:3306/ecom_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
mvn clean install
mvn spring-boot:run
| Method | Endpoint                  | Description                  |
| ------ | ------------------------- | ---------------------------- |
| GET    | `/api/products`           | Get all products             |
| GET    | `/api/product/{id}`       | Get product by ID            |
| POST   | `/api/product`            | Add new product (with image) |
| GET    | `/api/product/{id}/image` | Fetch product image by ID    |
// Fetch all products
fetch("http://localhost:8080/api/products")
  .then(response => response.json())
  .then(data => console.log(data));
🖼️ Uploading Products with Image

Use Postman or your frontend:

POST /api/product

Body → form-data:

product → JSON object (name, description, price, etc.)

imageFile → File upload
Hosting Together

Option 1 (Separate Repos): Host backend (Heroku, Render, Railway, or AWS) and frontend (Netlify, Vercel). Just point frontend API calls to your backend’s deployed URL.

Option 2 (Single Repo): Later you can merge backend + frontend in one repo and serve frontend as static files from Spring Boot.
🤝 Contributing

Pull requests are welcome!
For major changes, please open an issue first to discuss what you would like to change.
