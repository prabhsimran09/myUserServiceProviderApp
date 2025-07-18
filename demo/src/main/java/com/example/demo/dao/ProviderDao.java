package com.example.demo.dao;

import com.example.demo.models.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProviderDao extends JpaRepository<ServiceProvider, Long> {

    @Query("select COUNT(p) from ServiceProvider p where p.serviceProviderID=:providerId")
    int getProviderCount(@Param("providerId")String providerId);
}
