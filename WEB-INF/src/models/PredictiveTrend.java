package models;

public class PredictiveTrend {
    private Integer trendId;
    private Locations location;
    private String riskType;    // values: air_quality, water_security, green_cover, heat_island, infrastructure
    private Integer forecastYear;
    private Double forecastValue;
    private String modelUsed;

    // --- Getters and Setters ---
    public Integer getTrendId() {
        return trendId;
    }
    public void setTrendId(Integer trendId) {
        this.trendId = trendId;
    }



    public String getRiskType() {
        return riskType;
    }
    public void setRiskType(String riskType) {
        this.riskType = riskType;
    }

    public Integer getForecastYear() {
        return forecastYear;
    }
    public void setForecastYear(Integer forecastYear) {
        this.forecastYear = forecastYear;
    }

    public Double getForecastValue() {
        return forecastValue;
    }
    public void setForecastValue(Double forecastValue) {
        this.forecastValue = forecastValue;
    }

    public String getModelUsed() {
        return modelUsed;
    }       
    public void setModelUsed(String modelUsed) {
        this.modelUsed = modelUsed;
    }
    public Locations getLocation() {
        return location;
    }
    public void setLocation(Locations location) {
        this.location = location;
    }
}
