package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CreateBillRequest {

    private String userId;
    private String providerId;
    private final String currency = "USD";
    private double amount;
    private LocalDateTime dueDate;

    @Override
    public String toString() {
        return "{" +
                "userId='" + userId + '\'' +
                ", providerId='" + providerId + '\'' +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", dueDate=" + dueDate +
                '}';
    }
}
