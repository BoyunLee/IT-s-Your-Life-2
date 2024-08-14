package com.multi.spring2.finance.domain;

import lombok.Data;

@Data
public class Transfer {
    private String accountFrom;
    private String accountTo;
    private Double amount;
    // getters and setters
}