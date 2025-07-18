package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentRequest {
    private String billId;
    private final String currency = "USD";
    private double amountPaid;

    @Override
    public String toString() {
        return "{" +
                "billId='" + billId + '\'' +
                ", currency='" + currency + '\'' +
                ", amountPaid=" + amountPaid +
                '}';
    }
}
