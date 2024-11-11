package com.test.techApplication.ATMStatusApplication.repository;

import com.test.techApplication.ATMStatusApplication.Entitty.ATMStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDateTime;
import java.util.List;

public interface ATMStatusRepository extends JpaRepository<ATMStatus, Long> {
    List<String> findFailures();
    List<String> findCameraLogsBetweenTimes(LocalDateTime startTime, LocalDateTime endTime);
}
