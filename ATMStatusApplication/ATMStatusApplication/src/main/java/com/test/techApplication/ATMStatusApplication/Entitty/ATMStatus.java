package com.test.techApplication.ATMStatusApplication.Entitty;


import java.time.LocalDateTime;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;


/**
 * Entity representing the status of an ATM, including operational status and failure information.
 */
@Entity
@Table(name = "atm_status")
public class ATMStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "atm_id", nullable = false)
    private String atmId;  // Unique identifier for each ATM

    @Column(name = "status", nullable = false)
    private String status;  // The current status of the ATM (e.g., "Working", "Failure", "Maintenance")

    @Column(name = "failure_details")
    private String failureDetails;  // Details of the failure, if any (e.g., device malfunction)

    @Column(name = "last_checked", nullable = false)
    private LocalDateTime lastChecked;  // Timestamp of the last status check

    public ATMStatus() {
    }

    public ATMStatus(String atmId, String status, String failureDetails, LocalDateTime lastChecked) {
        this.atmId = atmId;
        this.status = status;
        this.failureDetails = failureDetails;
        this.lastChecked = lastChecked;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAtmId() {
        return atmId;
    }

    public void setAtmId(String atmId) {
        this.atmId = atmId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailureDetails() {
        return failureDetails;
    }

    public void setFailureDetails(String failureDetails) {
        this.failureDetails = failureDetails;
    }

    public LocalDateTime getLastChecked() {
        return lastChecked;
    }

    public void setLastChecked(LocalDateTime lastChecked) {
        this.lastChecked = lastChecked;
    }

    @Override
    public String toString() {
        return "ATMStatus{" +
                "id=" + id +
                ", atmId='" + atmId + '\'' +
                ", status='" + status + '\'' +
                ", failureDetails='" + failureDetails + '\'' +
                ", lastChecked=" + lastChecked +
                '}';
    }
}
