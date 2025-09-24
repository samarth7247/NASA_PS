package models;

import java.sql.Timestamp;

public class SustainabilityPassport {
    private Integer passportId;
    private Project project;
    private String blockchainHash;
    private Timestamp issuedAt;

    // --- Getters and Setters ---
    public Integer getPassportId() {
        return passportId;
    }
    public void setPassportId(Integer passportId) {
        this.passportId = passportId;
    }

    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }

    public String getBlockchainHash() {
        return blockchainHash;
    }
    public void setBlockchainHash(String blockchainHash) {
        this.blockchainHash = blockchainHash;
    }

    public Timestamp getIssuedAt() {
        return issuedAt;
    }
    public void setIssuedAt(Timestamp issuedAt) {
        this.issuedAt = issuedAt;
    }
}
