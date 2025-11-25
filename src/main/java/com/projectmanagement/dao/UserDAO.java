package com.projectmanagement.dao;
import com.projectmanagement.model.User;
import java.sql.*;

public class UserDAO {
  public User findByEmailAndPassword(String email, String password) {
    String sql = "SELECT * FROM users WHERE email=? AND password=?";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1, email); ps.setString(2, password);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) {
          return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("role"));
        }
      }
    } catch (SQLException ex) { ex.printStackTrace(); }
    return null;
  }

  public void create(User u) {
    String sql = "INSERT INTO users (name,email,password,role) VALUES (?,?,?,?)";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setString(1, u.getName()); ps.setString(2, u.getEmail()); ps.setString(3, u.getPassword()); ps.setString(4, u.getRole());
      ps.executeUpdate();
    } catch (SQLException e) { e.printStackTrace(); }
  }

  public User findById(int id) {
    String sql = "SELECT * FROM users WHERE id=?";
    try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
      ps.setInt(1, id);
      try (ResultSet rs = ps.executeQuery()) {
        if (rs.next()) return new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("password"), rs.getString("role"));
      }
    } catch (SQLException e) { e.printStackTrace(); }
    return null;
  }
}
