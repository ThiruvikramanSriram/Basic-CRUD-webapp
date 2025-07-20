# Employee Management System (Full Stack CRUD Web App)

A full-stack web application for managing employee data with complete **CRUD (Create, Read, Update, Delete)** functionality.

---

## 🚀 Features

- Add new employees
- View all employees
- Update employee details
- Delete employees
- Responsive and clean UI

---

## 🛠️ Tech Stack

### 🔧 Backend
- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **MySQL Database**

### 🎨 Frontend
- **Angular**
- **TypeScript**
- **Bootstrap / HTML / CSS**

---

## 🗃️ Project Structure

FullStackCRUDProject/
├── ANGSPG/ # Angular Frontend
│ └── src/ # Component-based UI
├── EMS/ # Spring Boot Backend
│ └── src/ # REST APIs and Service Logic
├── README.md

yaml
Copy
Edit

---

## 🔧 How to Run

### 📦 Backend (Spring Boot)

1. Go to `EMS/`
2. Configure your `application.properties` with MySQL DB credentials
3. Run:
   ```bash
   ./mvnw spring-boot:run
💻 Frontend (Angular)
Go to ANGSPG/

Install dependencies:

bash
Copy
Edit
npm install
Run Angular dev server:

bash
Copy
Edit
ng serve
App will run at http://localhost:4200

📌 Notes
✅ Make sure MySQL is running and database is created

✅ Backend exposes REST APIs

✅ CORS should be enabled in backend for Angular access

✅ Frontend consumes backend API using Angular Services

✅ Project is split cleanly: ANGSPG for frontend and EMS for backend