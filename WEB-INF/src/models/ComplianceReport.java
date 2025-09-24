package models;

import java.sql.Date;

public class ComplianceReport {
    private Integer reportId;
    private Project project;
    private String zoningStatus; // values: approved, pending, rejected
    private Boolean environmentalClearance;
    private Boolean greenBuildingCertification;
    private Date issuedAt;

    // --- Getters and Setters ---
    public Integer getReportId() {
        return reportId;
    }
    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    public String getZoningStatus() {
        return zoningStatus;
    }
    public void setZoningStatus(String zoningStatus) {
        this.zoningStatus = zoningStatus;
    }

    public Boolean getEnvironmentalClearance() {
        return environmentalClearance;
    }
    public void setEnvironmentalClearance(Boolean environmentalClearance) {
        this.environmentalClearance = environmentalClearance;
    }

    public Boolean getGreenBuildingCertification() {
        return greenBuildingCertification;
    }
    public void setGreenBuildingCertification(Boolean greenBuildingCertification) {
        this.greenBuildingCertification = greenBuildingCertification;
    }

    public Date getIssuedAt() {
        return issuedAt;
    }
    public void setIssuedAt(Date issuedAt) {
        this.issuedAt = issuedAt;
    }
}
