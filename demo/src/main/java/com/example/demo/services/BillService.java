package com.example.demo.services;

import com.example.demo.models.Bill;
import com.example.demo.models.BillResponse;
import com.example.demo.models.CreateBillRequest;
import com.example.demo.models.PaymentRequest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BillService {

    List<Bill> listAllBillsForUser(String userId);
    Long createBill(CreateBillRequest request);
    Long updateBill(PaymentRequest paymentRequest);
    Bill getBill(Long billId);
    List<Bill> getPendingBillsForUserId(String userId);
    List<Bill> getAllBillsForProviderId(String providerId);


}
