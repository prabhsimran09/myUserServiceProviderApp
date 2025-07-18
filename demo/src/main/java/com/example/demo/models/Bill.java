package com.example.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class Bill {

    @Id
    @GeneratedValue()
    private Long billId;
    private Long  userId ;

    private Long providerId;

    private final String currency = "USD";

    private double amount;

    private double paidAmount;

    private double dueAmount ;
    private LocalDateTime dueDate;

    public enum PaymentStatus{
        PENDING,
        PARTIALLY_PAID,
        PAID
    };

    private PaymentStatus paymentStatus;

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String toString() {
        return "{" +
                "billId=" + billId +
                ", userId=" + userId +
                ", providerId=" + providerId +
                ", currency='" + currency + '\'' +
                ", amount=" + amount +
                ", paidAmount=" + paidAmount +
                ", dueAmount=" + dueAmount +
                ", dueDate=" + dueDate +
                ", paymentStatus=" + paymentStatus +
                '}';
    }
}
