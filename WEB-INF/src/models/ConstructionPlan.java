package models;

import models.ConstructionPlan;
import utils.DBConnect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConstructionPlan {
    private String location;
    private String suggestion;
    private boolean zoningCompliant;
    // Constructor
    public ConstructionPlan() {}
    public ConstructionPlan(String location, String suggestion, boolean zoningCompliant) {
        this.location = location;
        this.suggestion = suggestion;
        this.zoningCompliant = zoningCompliant;
    }
    public ConstructionPlan(String location, String suggestion) {
        this.location = location;
        this.suggestion = suggestion;
    }
    public ConstructionPlan(String location) {
        this.location = location;
    }
    // Fetch all construction plans from DB
    
    public List<ConstructionPlan> getAllPlans() {
        List<ConstructionPlan> plans = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM construction_plan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ConstructionPlan plan = new ConstructionPlan(
                    rs.getString("location"),
                    rs.getString("suggestion"),
                    rs.getBoolean("zoning_compliant")
                );
                plans.add(plan);
            }
            rs.close(); ps.close(); conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return plans;
    }
    public List<ConstructionPlan> getPlansByLocation(String location) {
        List<ConstructionPlan> plans = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM construction_plan WHERE location = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ConstructionPlan plan = new ConstructionPlan(
                    rs.getString("location"),
                    rs.getString("suggestion"),
                    rs.getBoolean("zoning_compliant")
                );
                plans.add(plan);
            }
            rs.close(); ps.close(); conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return plans;
    }

    public boolean savePlan() {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "INSERT INTO construction_plan (location, suggestion, zoning_compliant) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.location);
            ps.setString(2, this.suggestion);
            ps.setBoolean(3, this.zoningCompliant);
            int rows = ps.executeUpdate();
            ps.close(); conn.close();
            return rows > 0;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updatePlan() {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "UPDATE construction_plan SET suggestion = ?, zoning_compliant = ? WHERE location = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.suggestion);
            ps.setBoolean(2, this.zoningCompliant);
            ps.setString(3, this.location);
            int rows = ps.executeUpdate();
            ps.close(); conn.close();
            return rows > 0;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deletePlan() {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "DELETE FROM construction_plan WHERE location = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, this.location);
            int rows = ps.executeUpdate();
            ps.close(); conn.close();
            return rows > 0;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ConstructionPlan getPlanByLocation(String location) {
        ConstructionPlan plan = null;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM construction_plan WHERE location = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                plan = new ConstructionPlan(
                    rs.getString("location"),
                    rs.getString("suggestion"),
                    rs.getBoolean("zoning_compliant")
                );
            }
            rs.close(); ps.close(); conn.close();
        } catch(Exception e) {
            e.printStackTrace();   
        }
        return plan;
    }   
    public boolean planExists(String location) {
        boolean exists = false;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT(*) FROM construction_plan WHERE location = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, location);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                exists = rs.getInt(1) > 0;
            }
            rs.close(); ps.close(); conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return exists;
    }
    public boolean deleteAllPlans() {
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "DELETE FROM construction_plan";
            PreparedStatement ps = conn.prepareStatement(sql);
            int rows = ps.executeUpdate();
            ps.close(); conn.close();
            return rows > 0;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public int countPlans() {
        int count = 0;
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT COUNT(*) FROM construction_plan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                count = rs.getInt(1);
            }
            rs.close(); ps.close(); conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return count;   
    }
    public List<ConstructionPlan> searchPlans(String keyword) {
        List<ConstructionPlan> plans = new ArrayList<>();
        try {
            Connection conn = DBConnect.getConnection();
            String sql = "SELECT * FROM construction_plan WHERE location LIKE ? OR suggestion LIKE ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            String likeKeyword = "%" + keyword + "%";
            ps.setString(1, likeKeyword);
            ps.setString(2, likeKeyword);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                ConstructionPlan plan = new ConstructionPlan(
                    rs.getString("location"),
                    rs.getString("suggestion"),
                    rs.getBoolean("zoning_compliant")
                );
                plans.add(plan);
            }
            rs.close(); ps.close(); conn.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return plans;
    }
    public void printPlans() {
        List<ConstructionPlan> plans = getAllPlans();
        for(ConstructionPlan plan : plans) {
            System.out.println("Location: " + plan.getLocation());
            System.out.println("Suggestion: " + plan.getSuggestion());
            System.out.println("Zoning Compliant: " + plan.isZoningCompliant());
            System.out.println("---------------------------");
        }
    }
    public void printPlanDetails() {
        System.out.println("Location: " + this.location);
        System.out.println("Suggestion: " + this.suggestion);
        System.out.println("Zoning Compliant: " + this.zoningCompliant);
    }
    public static void main(String[] args) {
        ConstructionPlan cp = new ConstructionPlan();
        cp.printPlans();
    }
    public String toString() {
        return "ConstructionPlan [location=" + location + ", suggestion=" + suggestion + ", zoningCompliant=" + zoningCompliant + "]";
    }
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        ConstructionPlan other = (ConstructionPlan) obj;
        return location.equals(other.location);
    }
    public int hashCode() {
        return location.hashCode();
    }
    

    // Getters and Setters
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getSuggestion() {
        return suggestion;
    }
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
    public boolean isZoningCompliant() {
        return zoningCompliant;
    }
    public void setZoningCompliant(boolean zoningCompliant) {
        this.zoningCompliant = zoningCompliant;
    }
    
}
