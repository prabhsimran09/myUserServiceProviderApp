package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Payment {

    @GeneratedValue
    @Id
    private Long paymentId;
    private Long billId;
    private String currency;
    private double amountPaid;
    private Instant timestamp;

    @Override
    public String toString() {
        return "{" +
                "paymentId=" + paymentId +
                ", billId=" + billId +
                ", currency='" + currency + '\'' +
                ", amountPaid=" + amountPaid +
                ", timestamp=" + timestamp +
                '}';
    }
}
