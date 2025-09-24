package models;

public class Locations {
    private Integer locationId;
    private String city;
    private String state;
    private String country;
    private Double latitude;
    private Double longitude;

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

    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
}
