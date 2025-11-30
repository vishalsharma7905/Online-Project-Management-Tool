# Online Project Management (Java Servlet + JDBC)

# Online Project Management Tool

A simple Java web application for managing projects, tasks, and team members. Built with Servlets, JSP, and JDBC, backed by MySQL.

---

## 📋 Overview

This is a project management system that allows users to create and manage projects, organize tasks, and collaborate with team members. The application supports role-based access (Admin, Project Manager, and Team Member) with a clean, easy-to-use interface.

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|-----------|
| **Backend** | Java (Servlets, JSP) |
| **Database Access** | JDBC |
| **Database** | MySQL (`project_management_db`) |
| **Build Tool** | Maven |
| **Server** | Apache Tomcat |
| **Deployment** | WAR (Web Archive) |

---

## ✨ Features

- ✅ User authentication with role-based access control
- ✅ Project creation and management
- ✅ Task assignment and tracking
- ✅ Team member management
- ✅ Three user roles: Admin, Project Manager, Team Member
- ✅ Demo users for testing
- ✅ Simple, responsive JSP-based UI

---
## 📁 Project Structure

Online-Project-Management-Tool/
├── src/main/java/com/projectmanagement/
│ ├── servlet/ # Request handlers
│ ├── dao/ # Database access layer
│ ├── model/ # Entity classes
│ └── util/ # Utility classes
├── src/main/webapp/
│ └── jsp/ # JSP templates
├── sql/
│ └── schema.sql # Database schema
├── pom.xml # Maven configuration
└── target/
└── online-project-management.war



## 🚀 Getting Started

### Prerequisites

- Java 8 or higher
- MySQL Server
- Apache Tomcat 9+
- Maven 3.6+

### Installation Steps

#### 1. **Setup the Database**

#### 2. **Update Database Configuration**
- Navigate to: `src/main/java/com/projectmanagement/dao/DBUtil.java`
- Update the following credentials:

#### 3. **Build the Project**

#### 4. **Deploy on Tomcat**
- Copy `target/online-project-management.war` to `TOMCAT_HOME/webapps/`
- Start Tomcat

#### 5. **Access the Application**


---

## 👤 Demo Login Credentials

| Role | Email | Password |
|------|-------|----------|
| **Admin** | `vishal@example.com` | `password` |
| **Project Manager** | `chetan@example.com` | `password` |
| **Team Member** | `kushal@example.com` | `password` |

---

## 📖 Usage Guide

1. **Login** with demo credentials
2. **Create Projects** (Admin/PM only)
3. **Add Tasks** to projects
4. **Assign Team Members** to tasks
5. **Track Progress** from the dashboard

---

## 🔧 Configuration

### Database Connection (DBUtil.java)


By TEAM ----- Revenant Coders.
