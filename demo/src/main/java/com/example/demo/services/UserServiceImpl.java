package com.example.demo.services;

import com.example.demo.dao.UserDao;
import com.example.demo.models.Customer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    UserDao userDao;

    public UserServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }


    @Override
    public List<Customer> listAllUsers() {
        return (List<Customer>)userDao.findAll();
    }

    @Override
    public Long addUser(String userName) {
        Customer customer = new Customer();
        customer.setUserName(userName);
        return userDao.save(customer).getUserID();
    }

    @Override
    public Customer getUser(String userId) {
       Optional<Customer> user =  userDao.findById(Long.valueOf(userId));
       return user.orElse(null);
    }

    @Override
    public boolean checkIfCustomerExists(String userId){
        int count = userDao.getCustomerCount(userId);
        return count > 0;
    }


}
