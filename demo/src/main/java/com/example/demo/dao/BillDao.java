package com.example.demo.dao;

import com.example.demo.models.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BillDao extends JpaRepository<Bill, Long> {

    @Query("Select b from Bill b where b.providerId=:providerId")
    Optional<List<Bill>> findByServiceProviderId(@Param("providerId") String providerId);

    @Query("Select b from Bill b where b.userId=:userId and b.paymentStatus = PENDING")
    Optional<List<Bill>> getPendingBillsForUserId(@Param("userId") String userId);

    @Query("Select b from Bill b where b.userId=:userId")
    Optional<List<Bill>> findByUserId(String userId);


}
