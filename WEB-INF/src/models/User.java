package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import utils.DBConnect;
import java.sql.ResultSet;

public class User {
    private Integer userId;
    private String name;
    private String email;
    private String passwordHash;
    private String role; // values: buyer, builder, admin
    private Timestamp createdAt;

    
    
    // --- Constructors ---
    public User() {
        // Default constructor
    }

    public User(Integer userId, String name, String email, String passwordHash, String role, Timestamp createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.createdAt = createdAt;
    }

    public User(String name, String email, String passwordHash, String role) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

     //signup meathuoth
     public boolean saveUser() {
         boolean flag = false;
         Connection con = DBConnect.getConnection();
            String sql = "INSERT INTO users (name, email, password_hash, role, created_at) VALUES (?, ?, ?, ?, ?)"; 
            try {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, this.name);
                ps.setString(2, this.email);
                ps.setString(3, this.passwordHash);
                ps.setString(4, this.role);
                ps.setTimestamp(5, this.createdAt);
                
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    flag = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (con != null) {
                        con.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        return flag;
    }


    // signin modal
    public static User signinUser(String email, String password) {
        User user = null;
        Connection con = DBConnect.getConnection();
        String sql = "SELECT * FROM users WHERE email = ? AND password_hash = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);
            // ps.setString(3, role);
            var rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setRole(rs.getString("role"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
    public User getUserById(int userId) {
        User user = null;
        String sql = "SELECT * FROM users WHERE user_id=?";
        try (Connection conn = DBConnect.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPasswordHash(rs.getString("password_hash"));
                user.setRole(rs.getString("role"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }   



    // --- Getters and Setters ---
    public Integer getUserId() {
        return userId;
    }
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
