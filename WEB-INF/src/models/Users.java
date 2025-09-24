package models;

import java.sql.Timestamp;
import java.util.Date;

public class Users {
    private Integer userId;
    private String name;
    private String email;
    private String passwordHash;
    private String role; // values: buyer, builder, admin
    private Timestamp createdAt;

    
    
    // --- Constructors ---
    public Users() {
        // Default constructor
    }

    public Users(Integer userId, String name, String email, String passwordHash, String role, Timestamp createdAt) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.createdAt = createdAt;
    }

    public Users(String name, String email, String passwordHash, String role) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.role = role;
        this.createdAt = new Timestamp(System.currentTimeMillis());
    }

    // --- Signup Logic ---
    // This is a static method for demonstration. In a real app, use a service/DAO layer.
    public static Users signup(String name, String email, String password, String role) {
        Users user = new Users();
        user.setName(name);
        user.setEmail(email);
        user.setPasswordHash(hashPassword(password));
        user.setRole(role);
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        // Save user to DB here (pseudo-code)
        // UserDAO.save(user);
        return user;
    }

    // --- Signin Logic ---
    public static Users signin(String email, String password) {
        // Fetch user from DB by email (pseudo-code)
        // Users user = UserDAO.findByEmail(email);
        Users user = null; // Replace with actual DB fetch
        if (user != null && user.getPasswordHash().equals(hashPassword(password))) {
            return user;
        }
        return null;
    }

    // --- Password Hashing Utility ---
    private static String hashPassword(String password) {
        // Simple hash for demonstration. Use BCrypt or similar in production.
        return Integer.toHexString(password.hashCode());
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
