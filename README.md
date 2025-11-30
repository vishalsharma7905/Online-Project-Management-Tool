# Online Project Management (Java Servlet + JDBC)

Online Project Management Tool
Simple Java web app for managing projects, tasks, and team members using Servlets, JSP, and JDBC with MySQL as the backend.

Tech stack
Java (Servlets, JSP)

JDBC for database access

MySQL (database: project_management_db)

Maven for build (pom.xml)

Apache Tomcat for deployment (WAR)

Features
Basic project and user management (admin, project manager, member roles).

Login with demo users for quick testing.

Simple UI using JSP pages served by servlets.

Project structure
src/main/java/com/projectmanagement – servlets, DAO classes, and utilities.

resources – config and supporting resources.

sql – database schema and initial data (schema.sql).

target/online-project-management.war – generated WAR file after build.

How to run locally
Create the database by running sql/schema.sql in your MySQL server (database name: project_management_db).

Open src/main/java/com/projectmanagement/dao/DBUtil.java and update your MySQL URL, username, and password.

Build the project with Maven:

bash
mvn clean package
Take target/online-project-management.war and deploy it on Apache Tomcat.

Start Tomcat and open the app in your browser (for example: http://localhost:8080/online-project-management).

Demo login users
Admin: vishal@example.com / password

Project Manager: chetan@example.com / password

Team Member: kushal@example.com / password

Future improvements
Validation and better error handling on forms.

Role-based access control for each module.

UI improvements (CSS framework like Bootstrap).

More detailed project and task tracking (status, deadlines, comments).

