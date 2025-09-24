package models;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import utils.DBConnect;

public class Project {
    private Integer projectId;
    private User user;
    private Locations location;
    private String projectName;
    private String projectType; // residential, commercial, mixed
    private String status;      // planning, ongoing, completed
    private Boolean sustainabilityPassport;
    private Timestamp createdAt;

    // --- Constructors ---
    public Project() {}
    
    public Project(Integer projectId, User user, Locations location, String projectName, String projectType,
                   String status, Boolean sustainabilityPassport, Timestamp createdAt) {
        this.projectId = projectId;
        this.user = user;       
        this.location = location;
        this.projectName = projectName;
        this.projectType = projectType;
        this.status = status;
        this.sustainabilityPassport = sustainabilityPassport;
        this.createdAt = createdAt;
    }

    // --- Methods ---

    // Get a project by its ID
    public Project getProjectById(int projectId) {
        String sql = "SELECT p.*, l.city, l.state, l.country, l.latitude, l.longitude " +
                     "FROM projects p " +
                     "INNER JOIN locations l ON p.location_id = l.location_id " +
                     "WHERE p.project_id = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Project p = new Project();
                p.setProjectId(rs.getInt("project_id"));

                // Populate user (assuming User class has a method to fetch by ID)
                User u = new User().getUserById(rs.getInt("user_id"));
                p.setUser(u);

                // Populate location
                Locations location = new Locations();
                location.setLocationId(rs.getInt("location_id"));
                location.setCity(rs.getString("city"));
                location.setState(rs.getString("state"));
                location.setCountry(rs.getString("country"));
                location.setLatitude(rs.getDouble("latitude"));
                location.setLongitude(rs.getDouble("longitude"));
                p.setLocation(location);

                p.setProjectName(rs.getString("project_name"));
                p.setProjectType(rs.getString("project_type"));
                p.setStatus(rs.getString("status"));
                p.setSustainabilityPassport(rs.getBoolean("sustainability_passport"));
                p.setCreatedAt(rs.getTimestamp("created_at"));

                return p;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Update an existing project
    public boolean updateProject(Project p) {
        String sql = "UPDATE projects SET location_id=?, project_name=?, project_type=?, status=?, sustainability_passport=? WHERE project_id=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getLocation().getLocationId());
            ps.setString(2, p.getProjectName());
            ps.setString(3, p.getProjectType());
            ps.setString(4, p.getStatus());
            ps.setBoolean(5, p.getSustainabilityPassport());
            ps.setInt(6, p.getProjectId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete a project by its ID
    public boolean deleteProject(int projectId) {
        String sql = "DELETE FROM projects WHERE project_id=?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, projectId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    

    public List<Project> getAllProjectsByUser(User user) {
        List<Project> projects = new ArrayList<>();
        // Join with locations table to fetch location details
        String sql = "SELECT p.*, l.city, l.state, l.country, l.latitude, l.longitude " +
                     "FROM projects p " +
                     "INNER JOIN locations l ON p.location_id = l.location_id " +
                     "WHERE p.user_id = ?";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, user.getUserId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Project p = new Project();
                p.setProjectId(rs.getInt("project_id"));
                p.setUser(user);

                // Populate location
                Locations location = new Locations();
                location.setLocationId(rs.getInt("location_id"));
                location.setCity(rs.getString("city"));
                location.setState(rs.getString("state"));
                location.setCountry(rs.getString("country"));
                location.setLatitude(rs.getDouble("latitude"));
                location.setLongitude(rs.getDouble("longitude"));
                p.setLocation(location);

                p.setProjectName(rs.getString("project_name"));
                p.setProjectType(rs.getString("project_type"));
                p.setStatus(rs.getString("status"));
                p.setSustainabilityPassport(rs.getBoolean("sustainability_passport"));
                p.setCreatedAt(rs.getTimestamp("created_at"));

                projects.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return projects;
    }

    public boolean addProject(Project p) {
        String sql = "INSERT INTO projects (user_id, location_id, project_name, project_type, status, sustainability_passport, created_at) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = DBConnect.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getUser().getUserId());
            ps.setInt(2, p.getLocation().getLocationId());
            ps.setString(3, p.getProjectName());
            ps.setString(4, p.getProjectType());
            ps.setString(5, p.getStatus());
            ps.setBoolean(6, p.getSustainabilityPassport());
            ps.setTimestamp(7, p.getCreatedAt());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // --- Getters and Setters ---
    public Integer getProjectId() {
        return projectId;
    }
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public Locations getLocation() {
        return location;
    }
    public void setLocation(Locations location) {
        this.location = location;
    }

    public String getProjectName() {
        return projectName;
    }
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getSustainabilityPassport() {
        return sustainabilityPassport;
    }
    public void setSustainabilityPassport(Boolean sustainabilityPassport) {
        this.sustainabilityPassport = sustainabilityPassport;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
