package com.example.demo.dao;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserDao extends CrudRepository<Customer,Long> {

    @Query("select COUNT(u) from Customer u where u.userID=:userId")
    int getCustomerCount(@Param("userId")String userId);

}
