package com.test.techApplication.ATMStatusApplication.Entitty;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Entity representing a camera log or footage associated with an ATM.
 */
@Getter
@Setter
@Entity
@Table(name = "camera_logs")
public class CameraLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "atm_id", nullable = false)
    private String atmId;  // The ATM ID where the camera log was captured

    @Column(name = "log_type", nullable = false)
    private String logType;  // Type of the log (e.g., "Image", "Video")

    @Column(name = "log_data", nullable = false)
    private String logData;  // The actual log data (could be a file path, URL, or binary data)

    @Column(name = "timestamp", nullable = false)
    private LocalDateTime timestamp;  // Timestamp of when the camera log was created

    public CameraLog() {
    }

    public CameraLog(String atmId, String logType, String logData, LocalDateTime timestamp) {
        this.atmId = atmId;
        this.logType = logType;
        this.logData = logData;
        this.timestamp = timestamp;
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

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getLogData() {
        return logData;
    }

    public void setLogData(String logData) {
        this.logData = logData;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "CameraLog{" +
                "id=" + id +
                ", atmId='" + atmId + '\'' +
                ", logType='" + logType + '\'' +
                ", logData='" + logData + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
