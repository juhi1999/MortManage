package com.example.MortManage.DAO;

import com.example.MortManage.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    List<Customer> AllCustomers();

    Customer findById(int theId);

    Customer save(Customer theCustomer);

    void deleteById(int theId);
}
