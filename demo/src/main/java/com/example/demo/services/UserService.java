package com.example.demo.services;

import com.example.demo.models.Customer;

import java.util.List;

public interface UserService {

    List<Customer> listAllUsers();
    Long addUser(String userName);
    Customer getUser(String userId);
    boolean checkIfCustomerExists(String userId);
}
