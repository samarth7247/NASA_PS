package models;

import java.sql.Timestamp;

public class Property {
    private Integer propertyId;
    private User user;
    private Locations location;
    private String propertyName;
    private String propertyType; // values: residential, commercial, land
    private Double sizeSqft;
    private Double price;
    private Timestamp createdAt;

    // --- Getters and Setters ---
    public Integer getPropertyId() {
        return propertyId;
    }
    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
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

    public String getPropertyName() {
        return propertyName;
    }
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }
    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Double getSizeSqft() {
        return sizeSqft;
    }
    public void setSizeSqft(Double sizeSqft) {
        this.sizeSqft = sizeSqft;
    }

    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }
}
