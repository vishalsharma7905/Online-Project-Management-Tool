# Online Project Management (Java Servlet + JDBC)

**Package:** com.projectmanagement  
**Database:** project_management_db (MySQL)

This is a demo Java web application prepared for Review-1. It contains servlets, JSPs, DAOs and JDBC integration.

## Run
1. Create DB: run `sql/schema.sql` in MySQL.
2. Update DB credentials in `src/main/java/com/projectmanagement/dao/DBUtil.java`.
3. Build: `mvn clean package`
4. Deploy `target/online-project-management.war` to Tomcat.

Seeded users (demo):  
- admin: vishal@example.com / password  
- pm: chetan@example.com / password  
- member: kushal@example.com / password


