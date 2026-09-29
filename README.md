# 🎓 Student Management System - Java & MySQL

Student Management System is a console-based student administration application developed using **Java, MySQL, and JDBC**.

The project provides a structured system for managing **students, courses, grades, and user access** through a role-based authentication system.

The application demonstrates practical implementation of **CRUD operations, database connectivity, authentication, role-based access control, input validation, relational database design, and modular Java development**.

---

## ✨ Features

### 🔐 Authentication & Role-Based Access

The system provides authentication and role-based access for different users.

* Admin login
* Staff login
* Username and password authentication
* Role-based access control
* Admin-specific access
* Staff-specific access restrictions
* Login validation
* Database-based authentication
* Secure password handling

---

### 📊 Dashboard

The dashboard provides an overview of the student management system.

* Total students
* Total courses
* Total grades
* Average marks
* Highest marks
* Lowest marks
* Role-based dashboard access
* Central navigation to system modules

Dashboard information is retrieved from the MySQL database and updated according to the current data.

---

### 👨‍🎓 Student Management

The Student Management module allows authorized users to manage student records.

* Add students
* View students
* Search students
* Update student information
* Delete student records
* Search by Student ID
* Search by name
* Search by email
* Search by course
* Student ID management
* Student name
* Email address
* Phone number
* Date of birth
* Gender
* Course assignment
* Enrollment date

---

### 📚 Course Management

The Course Management module allows users to maintain course information.

* Add courses
* View courses
* Search courses
* Update course information
* Delete course records
* Course ID
* Course name
* Course duration
* Course fees

---

### 📊 Grade Management

The Grade Management module allows academic results to be recorded and maintained.

* Add grades
* View grades
* Search grades
* Update grades
* Delete grade records
* Student ID association
* Subject
* Marks
* Grade
* Semester

---

### 🗄️ MySQL Database Integration

The application uses **MySQL** as its relational database.

The database contains dedicated tables for:

* Users
* Students
* Courses
* Grades

The relational database structure allows information to be stored, retrieved, updated, and deleted efficiently.

---

### 🔗 JDBC Integration

**Java Database Connectivity (JDBC)** is used to connect the Java application with MySQL.

The application implements:

* MySQL database connection
* SQL queries
* Prepared statements
* Database authentication
* INSERT operations
* SELECT operations
* UPDATE operations
* DELETE operations
* Connection handling
* Exception handling

---

### ✅ Input Validation

The application includes input validation to improve data integrity and user experience.

Validation is implemented for appropriate user inputs including:

* Required fields
* Numeric values
* Student information
* Course information
* Grade information
* Login information

---

## 🛠️ Technologies Used

* **Java**
* **MySQL**
* **JDBC**
* **MySQL Connector/J**
* **SQL**
* **Object-Oriented Programming**
* **Exception Handling**
* **Input Validation**
* **Git**
* **GitHub**
* **Visual Studio Code**
* **MySQL Workbench**

---

## 📁 Project Structure

```text
student-management-system/
│
├── database/
│   └── database.sql
│
├── lib/
│   └── mysql-connector-j-9.7.0/
│       └── mysql-connector-j-9.7.0.jar
│
├── src/
│   ├── Main.java
│   ├── Login.java
│   ├── DatabaseConnection.java
│   ├── PasswordUtil.java
│   ├── InputHelper.java
│   ├── InputValidator.java
│   ├── DashboardService.java
│   │
│   ├── Student.java
│   ├── StudentService.java
│   ├── SearchStudentService.java
│   ├── ViewStudentService.java
│   ├── UpdateStudentService.java
│   └── DeleteStudentService.java
│   │
│   ├── Course.java
│   ├── CourseService.java
│   ├── SearchCourseService.java
│   ├── UpdateCourseService.java
│   └── DeleteCourseService.java
│   │
│   ├── Grade.java
│   ├── GradeService.java
│   ├── SearchGradeService.java
│   ├── ViewGradeService.java
│   ├── UpdateGradeService.java
│   └── DeleteGradeService.java
│
├── .vscode/
│   └── settings.json
│
├── .gitignore
└── README.md
```

---

## 🗄️ Database Structure

The project uses a MySQL database named:

```text
student_management_system
```

### Database Tables

```text
student_management_system
│
├── users
├── students
├── courses
└── grades
```

### 👤 Users

The `users` table stores user authentication information.

```text
users
├── user_id
├── username
└── password
```

The authentication system uses the stored user information to determine access to the application.

### 👨‍🎓 Students

The `students` table stores student personal and enrollment information.

Student records can be created, viewed, searched, updated, and deleted through the application.

### 📚 Courses

The `courses` table stores course information including:

* Course ID
* Course name
* Duration
* Fees

### 📊 Grades

The `grades` table stores academic information associated with students.

Grade information includes:

* Student ID
* Subject
* Marks
* Grade
* Semester

---

## 🔗 Database Relationships

The system uses relational database relationships to connect related academic information.

```text
              ┌─────────────┐
              │   Courses   │
              └──────┬──────┘
                     │
                     │
                     ▼
              ┌─────────────┐
              │  Students   │
              └──────┬──────┘
                     │
                     │
                     ▼
              ┌─────────────┐
              │   Grades    │
              └─────────────┘
```

The relationships allow the system to associate:

* Students with courses
* Grades with students
* Users with the authentication system

This provides a structured relational model for managing academic information.

---

## 🔐 Role-Based Access

The application provides different access levels based on the authenticated user's role.

### 👑 Admin

Admin users have access to the administrative functionality provided by the application.

```text
Admin Login
     │
     ▼
Admin Dashboard
     │
     ├── Student Management
     ├── Course Management
     ├── Grade Management
     └── Administrative Features
```

### 👤 Staff

Staff users have access to the functionality permitted for their role.

```text
Staff Login
     │
     ▼
Staff Dashboard
     │
     ├── Student Management
     ├── Course Management
     └── Grade Management
```

Admin-only functionality is restricted from staff users.

---

## 🔄 CRUD Operations

The system implements CRUD operations across the main management modules.

```text
Create
  ↓
Read
  ↓
Update
  ↓
Delete
```

### Student Records

* Create student
* Read student records
* Update student
* Delete student

### Course Records

* Create course
* Read course records
* Update course
* Delete course

### Grade Records

* Create grade
* Read grade records
* Update grade
* Delete grade

---

## 🚀 How to Run

### 1. Clone the Repository

```bash
git clone https://github.com/Avish-Tharu/student-management-system.git
```

### 2. Open the Project Folder

```bash
cd student-management-system
```

### 3. Open the Project in Visual Studio Code

```bash
code .
```

### 4. Set Up the MySQL Database

Open **MySQL Workbench** and execute:

```text
database/database.sql
```

This creates the required database and tables.

Make sure the MySQL server is running.

### 5. Configure the Database Connection

Open:

```text
src/DatabaseConnection.java
```

Make sure the following settings match your local MySQL configuration:

* Database name
* MySQL host
* MySQL port
* Username
* Password

### 6. Compile the Application

```bash
javac -cp "lib\mysql-connector-j-9.7.0\mysql-connector-j-9.7.0.jar" -d bin src\*.java
```

### 7. Run the Application

```bash
java -cp "bin;lib\mysql-connector-j-9.7.0\mysql-connector-j-9.7.0.jar" Main
```

### 8. Login

Enter a valid account stored in the `users` table.

The available functionality depends on the user's assigned role.

> **Security:** Never publish real database passwords or login credentials in the repository.

---

## 💻 Usage

After launching the application, users can:

1. Log into the system.
2. Access the dashboard according to their role.
3. Manage student records.
4. Add students.
5. View student information.
6. Search for students.
7. Update student information.
8. Delete student records.
9. Manage courses.
10. Add courses.
11. View courses.
12. Search for courses.
13. Update course information.
14. Delete course records.
15. Manage student grades.
16. Add grades.
17. View grades.
18. Search grades.
19. Update grades.
20. Delete grade records.
21. View dashboard statistics.
22. Navigate through role-based functionality.

---

## 🧪 Testing

The application was tested across its major functional modules before completing the project.

### 🔐 Authentication Testing

* [x] Admin login
* [x] Staff login
* [x] Valid credentials
* [x] Invalid login validation
* [x] Admin role recognition
* [x] Staff role recognition
* [x] Role-based access restrictions

### 👨‍🎓 Student Management Testing

* [x] Add Student
* [x] View Students
* [x] Search Student
* [x] Search by Student ID
* [x] Search by Name
* [x] Search by Email
* [x] Search by Course
* [x] Update Student
* [x] Delete Student

### 📚 Course Management Testing

* [x] Add Course
* [x] View Courses
* [x] Search Course
* [x] Update Course
* [x] Delete Course

### 📊 Grade Management Testing

* [x] Add Grade
* [x] View Grades
* [x] Search Grade
* [x] Update Grade
* [x] Delete Grade

### 📈 Dashboard & Database Testing

* [x] Dashboard functionality
* [x] JDBC connection
* [x] MySQL database operations
* [x] Student → Course relationship
* [x] Grade → Student relationship
* [x] Data persistence
* [x] CRUD operations
* [x] Dashboard statistics

### ✅ Final Testing Status

| Module                 | Status   |
| ---------------------- | -------- |
| Admin Authentication   | ✅ Passed |
| Staff Authentication   | ✅ Passed |
| Student Management     | ✅ Passed |
| Course Management      | ✅ Passed |
| Grade Management       | ✅ Passed |
| Dashboard              | ✅ Passed |
| JDBC Connection        | ✅ Passed |
| Database Relationships | ✅ Passed |
| Input Validation       | ✅ Passed |

**Final Testing: ✅ Completed**

---

## 🎯 Key Project Highlights

This project demonstrates practical experience with:

* Java application development
* Object-oriented programming
* MySQL database design
* JDBC integration
* Authentication systems
* Role-based access control
* CRUD operations
* SQL queries
* Prepared statements
* Database relationships
* Input validation
* Exception handling
* Modular Java development
* Console application development
* Git version control
* GitHub workflow
* Software testing

The project demonstrates how a Java application can interact with a relational database to manage real-world academic information.

---

## 📚 Learning Outcomes

Through this project, I practiced and improved my skills in:

* Java programming
* Object-oriented programming
* JDBC
* MySQL
* SQL
* CRUD operations
* Relational database design
* Database relationships
* Authentication
* Role-based access control
* Prepared statements
* Input validation
* Exception handling
* Console application development
* Modular programming
* Git and GitHub
* Software testing
* Database-driven application development

---

## 🔮 Future Improvements

Future versions of the project could include:

* 🖥️ JavaFX graphical user interface
* 🔐 Enhanced password security
* 👤 User management
* 📊 Advanced dashboard analytics
* 📈 GPA and academic performance tracking
* 📅 Attendance management
* 📄 Report generation
* 📑 PDF export
* 🔎 Advanced search and filtering
* 🔔 Notifications
* 🌐 REST API integration
* ☁️ Cloud database integration
* 🌍 Web-based version
* 📱 Mobile application

---

## 🏆 Project Status

**Status: ✅ Completed**

The Student Management System has completed its planned development and final testing phase.

The project demonstrates a complete Java-based database application with:

* Authentication
* Role-based access
* Student management
* Course management
* Grade management
* Dashboard functionality
* MySQL database integration
* JDBC connectivity
* CRUD operations
* Input validation
* Final functional testing

---


## 📄 License

This project was developed for educational and portfolio purposes.
