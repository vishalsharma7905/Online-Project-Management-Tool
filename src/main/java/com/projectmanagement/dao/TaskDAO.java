package com.projectmanagement.dao;
import com.projectmanagement.model.Task;
import java.sql.*;

public class TaskDAO {
  public void create(Task t) {
    String sql = "INSERT INTO tasks (project_id,title,assignee_id,status) VALUES (?,?,?,?)";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, t.getProjectId());
      ps.setString(2, t.getTitle());
      if (t.getAssigneeId() == null) ps.setNull(3, Types.INTEGER); else ps.setInt(3, t.getAssigneeId());
      ps.setString(4, t.getStatus());
      ps.executeUpdate();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  public void updateStatus(int id, String status) {
    String sql = "UPDATE tasks SET status=? WHERE id=?";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1, status); ps.setInt(2, id); ps.executeUpdate();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  public void delete(int id) {
    String sql = "DELETE FROM tasks WHERE id=?";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, id); ps.executeUpdate();
    } catch (SQLException e) { e.printStackTrace(); }
  }
}
