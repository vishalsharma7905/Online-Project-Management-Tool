-- Create DB and tables for project_management_db
CREATE DATABASE IF NOT EXISTS project_management_db;
USE project_management_db;

CREATE TABLE IF NOT EXISTS users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL,
  email VARCHAR(150) NOT NULL UNIQUE,
  password VARCHAR(100) NOT NULL,
  role ENUM('admin','pm','member') NOT NULL
);

CREATE TABLE IF NOT EXISTS projects (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(200) NOT NULL,
  description TEXT,
  start_date DATE,
  end_date DATE,
  manager_id INT,
  FOREIGN KEY (manager_id) REFERENCES users(id) ON DELETE SET NULL
);

CREATE TABLE IF NOT EXISTS tasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  project_id INT NOT NULL,
  title VARCHAR(200) NOT NULL,
  assignee_id INT,
  status ENUM('todo','in-progress','done') DEFAULT 'todo',
  FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
  FOREIGN KEY (assignee_id) REFERENCES users(id) ON DELETE SET NULL
);

INSERT IGNORE INTO users (id, name, email, password, role)
VALUES
  (1, 'Vishal Sharma', 'vishal@example.com', 'password', 'admin'),
  (2, 'Kushal Trivedi', 'kushal@example.com', 'password', 'pm'),
  (3, 'Asha Patel', 'asha@example.com', 'password', 'member');

INSERT IGNORE INTO projects (id, title, description, start_date, end_date, manager_id)
VALUES (1, 'Website Redesign', 'Refresh UI and improve performance', '2025-11-01', '2026-01-31', 2);

INSERT IGNORE INTO tasks (id, project_id, title, assignee_id, status)
VALUES (1,1,'Design mockups',3,'todo'), (2,1,'Implement components',3,'in-progress');
