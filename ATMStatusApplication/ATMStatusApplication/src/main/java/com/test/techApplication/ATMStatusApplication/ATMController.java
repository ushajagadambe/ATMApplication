package com.test.techApplication.ATMStatusApplication;

import com.test.techApplication.ATMStatusApplication.Entitty.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/atm")
public class ATMController {

    @Autowired
    private ATMService atmService;

    /**
     * Endpoint to get the total number of customers who interacted with ATMs in the last 24 hours.
     *
     * @return A {@link ResponseEntity} containing the total number of customers (as a {@link Long}) in the last 24 hours.
     * The response will have an HTTP status of 200 (OK) if the operation is successful.
     */
    @GetMapping("/customers/last-24-hours")
    public ResponseEntity<Long> getTotalCustomersLast24Hours() {
        return ResponseEntity.ok(atmService.getTotalCustomersLast24Hours());
    }

    /**
     * Endpoint to get a breakdown of ATM transactions by type (Deposit, Cash Withdrawal, Balance Information).
     *
     * @return A {@link ResponseEntity} containing a list of {@link Transaction} objects that represent the transaction breakdown.
     * The response will have an HTTP status of 200 (OK) if the operation is successful.
     */
    @GetMapping("/transactions/breakdown")
    public ResponseEntity<List<Transaction>> getTransactionBreakdown() {
        return ResponseEntity.ok(atmService.getTransactionBreakdown());
    }

    /**
     * Endpoint to retrieve a list of failures or incidents that occurred due to system errors or ATM device malfunctions.
     *
     * @return A {@link ResponseEntity} containing a list of strings, each representing a failure or incident description.
     * The response will have an HTTP status of 200 (OK) if the operation is successful.
     */
    @GetMapping("/failures")
    public ResponseEntity<List<String>> getFailures() {
        return ResponseEntity.ok(atmService.getFailures());
    }

    /**
     * Endpoint to fetch camera logs (images or videos) from ATMs within a specified time range.
     *
     * @param startTime The starting time for the camera log query in the format "yyyy-MM-dd HH:mm:ss".
     * @param endTime   The ending time for the camera log query in the format "yyyy-MM-dd HH:mm:ss".
     * @return A {@link ResponseEntity} containing a list of strings, each representing a log entry (either an image or video)
     * from the specified time range. The response will have an HTTP status of 200 (OK) if the operation is successful.
     */
    @GetMapping("/camera/logs")
    public ResponseEntity<List<String>> getCameraLogs(@RequestParam String startTime, @RequestParam String endTime) {
        return ResponseEntity.ok(atmService.getCameraLogs(startTime, endTime));
    }
}
