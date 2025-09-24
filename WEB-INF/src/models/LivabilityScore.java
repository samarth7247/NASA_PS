package models;

import java.sql.Timestamp;

public class LivabilityScore {
    private Integer scoreId;
    private Locations location;
    private Double overallScore;
    private Timestamp calculatedAt;

    // --- Getters and Setters ---
    public Integer getScoreId() {
        return scoreId;
    }
    public void setScoreId(Integer scoreId) {
        this.scoreId = scoreId;
    }

    public Locations getLocation() {
        return location;
    }
    public void setLocation(Locations location) {
        this.location = location;
    }

    public Double getOverallScore() {
        return overallScore;
    }
    public void setOverallScore(Double overallScore) {
        this.overallScore = overallScore;
    }

    public Timestamp getCalculatedAt() {
        return calculatedAt;
    }
    public void setCalculatedAt(Timestamp calculatedAt) {
        this.calculatedAt = calculatedAt;
    }
}
