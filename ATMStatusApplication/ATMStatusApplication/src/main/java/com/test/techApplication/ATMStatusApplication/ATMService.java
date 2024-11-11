package com.test.techApplication.ATMStatusApplication;

import com.test.techApplication.ATMStatusApplication.Entitty.Transaction;
import com.test.techApplication.ATMStatusApplication.repository.ATMStatusRepository;
import com.test.techApplication.ATMStatusApplication.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ATMService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ATMStatusRepository atmStatusRepository;

    /**
     * Retrieves the total number of unique customers who interacted with ATMs in the last 24 hours.
     *
     * @return The total number of customers in the last 24 hours.
     */
    public long getTotalCustomersLast24Hours() {
        // Get the current time minus 24 hours
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minus(24, ChronoUnit.HOURS);

        // Query the database for unique customer IDs (assuming a 'customerId' field in the Transaction model)
        long totalCustomers = transactionRepository.countDistinctByTimestampAfter(twentyFourHoursAgo);

        return totalCustomers;
    }

    /**
     * Retrieves the breakdown of transactions by type, such as Deposit, Cash Withdrawal, and Balance Information.
     *
     * @return A list of transactions broken down by type.
     */
    public List<Transaction> getTransactionBreakdown() {
        // Query the database for transactions in the last 24 hours
        LocalDateTime twentyFourHoursAgo = LocalDateTime.now().minus(24, ChronoUnit.HOURS);
        List<Transaction> transactions = transactionRepository.findByTimestampAfter(twentyFourHoursAgo);

        // Group transactions by type
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getType))
                .entrySet().stream()
                .map(entry -> new Transaction(entry.getKey(), entry.getValue().size(), entry.getValue().stream().mapToDouble(Transaction::getAmount).sum()))
                .collect(Collectors.toList());
    }

    /**
     * Retrieves the list of failures or incidents (downtime, device issues, etc.) in the ATM network.
     * This is based on system logs or monitoring information.
     *
     * @return A list of strings representing failure incidents.
     */
    public List<String> getFailures() {
        // Retrieve all ATMs with issues (assuming ATMStatusRepository has a 'status' field indicating failures)
        List<String> failures = atmStatusRepository.findFailures();
        return failures;
    }

    /**
     * Retrieves camera logs (images/videos) from ATMs based on the provided time range.
     *
     * @param startTime The start time of the range (in ISO format).
     * @param endTime   The end time of the range (in ISO format).
     * @return A list of strings representing camera logs (image or video file paths or URLs).
     */
    public List<String> getCameraLogs(String startTime, String endTime) {
        // Convert the startTime and endTime parameters to LocalDateTime objects
        LocalDateTime start = LocalDateTime.parse(startTime);
        LocalDateTime end = LocalDateTime.parse(endTime);

        // Retrieve camera logs based on the time range (this logic should query your camera log database or system)
        List<String> cameraLogs = atmStatusRepository.findCameraLogsBetweenTimes(start, end);

        return cameraLogs;
    }
}
