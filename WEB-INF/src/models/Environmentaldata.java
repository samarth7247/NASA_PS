package models;

import java.sql.Date;

public class Environmentaldata {
    private Integer envId;
    private Locations location;
    private Integer airQualityIndex;
    private Integer waterSecurityScore;
    private Double greenCoverPercentage;
    private Integer heatIslandRiskScore;
    private Integer ecosystemHealthScore;
    private Integer infrastructureQualityScore;
    private Date recordedAt;

    // --- Getters and Setters ---
    public Integer getEnvId() {
        return envId;
    }
    public void setEnvId(Integer envId) {
        this.envId = envId;
    }

    public Locations getLocation() {
        return location;
    }
    public void setLocation(Locations location) {
        this.location = location;
    }

    public Integer getAirQualityIndex() {
        return airQualityIndex;
    }
    public void setAirQualityIndex(Integer airQualityIndex) {
        this.airQualityIndex = airQualityIndex;
    }

    public Integer getWaterSecurityScore() {
        return waterSecurityScore;
    }
    public void setWaterSecurityScore(Integer waterSecurityScore) {
        this.waterSecurityScore = waterSecurityScore;
    }

    public Double getGreenCoverPercentage() {
        return greenCoverPercentage;
    }
    public void setGreenCoverPercentage(Double greenCoverPercentage) {
        this.greenCoverPercentage = greenCoverPercentage;
    }

    public Integer getHeatIslandRiskScore() {
        return heatIslandRiskScore;
    }
    public void setHeatIslandRiskScore(Integer heatIslandRiskScore) {
        this.heatIslandRiskScore = heatIslandRiskScore;
    }

    public Integer getEcosystemHealthScore() {
        return ecosystemHealthScore;
    }
    public void setEcosystemHealthScore(Integer ecosystemHealthScore) {
        this.ecosystemHealthScore = ecosystemHealthScore;
    }

    public Integer getInfrastructureQualityScore() {
        return infrastructureQualityScore;
    }
    public void setInfrastructureQualityScore(Integer infrastructureQualityScore) {
        this.infrastructureQualityScore = infrastructureQualityScore;
    }

    public Date getRecordedAt() {
        return recordedAt;
    }
    public void setRecordedAt(Date recordedAt) {
        this.recordedAt = recordedAt;
    }
}
