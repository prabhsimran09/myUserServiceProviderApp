package com.example.demo.services;

import com.example.demo.models.Payment;
import com.example.demo.models.PaymentRequest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PaymentService {

    Payment updatePayment(PaymentRequest request);
    Optional<List<Payment>> getPaymentsByBillId(Long billId);

}
