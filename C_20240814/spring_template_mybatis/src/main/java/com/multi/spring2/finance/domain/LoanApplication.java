package com.multi.spring2.finance.domain;

import lombok.Data;

@Data
public class LoanApplication {
    private String applicantName;
    private double amount;
    private int term;
    // getters and setters
}
