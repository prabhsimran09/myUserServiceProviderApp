package com.example.demo.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaymentResponse {
    private String paymentId;

    @Override
    public String toString() {
        return "{" +
                "paymentId='" + paymentId + '\'' +
                '}';
    }
}
