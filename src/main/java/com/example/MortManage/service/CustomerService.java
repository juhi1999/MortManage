package com.example.MortManage.service;

import com.example.MortManage.entity.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> FindAll();

    Customer findById(int theId);

    Customer save(Customer theCustomer);

    void deleteById(int theId);
}
