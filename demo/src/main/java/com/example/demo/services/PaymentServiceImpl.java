package com.example.demo.services;

import com.example.demo.dao.PaymentDao;
import com.example.demo.models.Payment;
import com.example.demo.models.PaymentRequest;
import org.springframework.stereotype.Service;
import java.util.List;

import java.time.Instant;
import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public Payment updatePayment(PaymentRequest paymentRequest) {
        Payment payment = new Payment();
        payment.setBillId(Long.valueOf(paymentRequest.getBillId()));
        payment.setTimestamp(Instant.now());
        payment.setCurrency("USD");
        payment.setAmountPaid(paymentRequest.getAmountPaid());

        return paymentDao.save(payment);
    }

    @Override
    public Optional<List<Payment>> getPaymentsByBillId(Long billId) {
        return paymentDao.findByBillId(String.valueOf(billId));
    }

}
