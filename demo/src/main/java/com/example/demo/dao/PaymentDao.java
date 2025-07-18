package com.example.demo.dao;

import com.example.demo.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PaymentDao extends JpaRepository<Payment, Long> {

    @Query("select p from Payment p where p.billId =:billId")
    Optional<List<Payment>> findByBillId(@Param("billId") String billId);
}
