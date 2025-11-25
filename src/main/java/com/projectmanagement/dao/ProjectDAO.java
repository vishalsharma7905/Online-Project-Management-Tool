package com.projectmanagement.dao;
import com.projectmanagement.model.Project;
import com.projectmanagement.model.Task;
import java.sql.*;
import java.util.*;

public class ProjectDAO {
  public List<Project> findAll() {
    List<Project> list = new ArrayList<>();
    String sql = "SELECT * FROM projects ORDER BY id DESC";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
      while (rs.next()) {
        Project p = new Project();
        p.setId(rs.getInt("id"));
        p.setTitle(rs.getString("title"));
        p.setDescription(rs.getString("description"));
        p.setStartDate(rs.getDate("start_date"));
        p.setEndDate(rs.getDate("end_date"));
        p.setManagerId(rs.getObject("manager_id") == null ? null : rs.getInt("manager_id"));
        p.setTasks(getTasksForProject(p.getId()));
        list.add(p);
      }
    } catch (SQLException e) { e.printStackTrace(); }
    return list;
  }

  public Project findById(int id) {
    String sql = "SELECT * FROM projects WHERE id=?";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          Project p = new Project();
          p.setId(rs.getInt("id"));
          p.setTitle(rs.getString("title"));
          p.setDescription(rs.getString("description"));
          p.setStartDate(rs.getDate("start_date"));
          p.setEndDate(rs.getDate("end_date"));
          p.setManagerId(rs.getObject("manager_id") == null ? null : rs.getInt("manager_id"));
          p.setTasks(getTasksForProject(p.getId()));
          return p;
        }
      }
    } catch (SQLException e) { e.printStackTrace(); }
    return null;
  }

  public void create(Project p) {
    String sql = "INSERT INTO projects (title,description,start_date,end_date,manager_id) VALUES (?,?,?,?,?)";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1, p.getTitle()); ps.setString(2, p.getDescription());
      ps.setDate(3, p.getStartDate()); ps.setDate(4, p.getEndDate());
      if (p.getManagerId() == null) ps.setNull(5, Types.INTEGER); else ps.setInt(5, p.getManagerId());
      ps.executeUpdate();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  public void updateTitle(int id, String newTitle) {
    String sql = "UPDATE projects SET title=? WHERE id=?";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1, newTitle); ps.setInt(2, id); ps.executeUpdate();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  private List<Task> getTasksForProject(int projectId) {
    List<Task> tasks = new ArrayList<>();
    String sql = "SELECT * FROM tasks WHERE project_id=?";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, projectId);
      try (ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
          Task t = new Task();
          t.setId(rs.getInt("id"));
          t.setProjectId(rs.getInt("project_id"));
          t.setTitle(rs.getString("title"));
          t.setAssigneeId(rs.getObject("assignee_id") == null ? null : rs.getInt("assignee_id"));
          t.setStatus(rs.getString("status"));
          tasks.add(t);
        }
      }
    } catch (SQLException e) { e.printStackTrace(); }
    return tasks;
  }
}
