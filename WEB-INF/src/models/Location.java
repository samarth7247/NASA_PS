package models;

import java.math.BigDecimal;

public class Locations {
    private Integer locationId;
    private String city;
    private String state;
    private String country;
    private BigDecimal latitude;
    private BigDecimal longitude;

    // --- Constructors ---
    public Locations() {}

    public Locations(Integer locationId, String city, String state, String country, BigDecimal latitude, BigDecimal longitude) {
        this.locationId = locationId;
        this.city = city;
        this.state = state;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }
    
    public Locations(Integer locationId) {
        this.locationId = locationId;
    }
    
    
    // --- Getters and Setters ---
    public Integer getLocationId() {
        return locationId;
    }
    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
}
