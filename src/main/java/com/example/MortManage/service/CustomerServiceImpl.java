package com.example.MortManage.service;

import com.example.MortManage.DAO.CustomerDAO;
import com.example.MortManage.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerDAO customerDAO;

    @Autowired
    public CustomerServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public List<Customer> FindAll() {
        return customerDAO.FindAll();
    }

    @Override
    public Customer findById(int theId) {
        return customerDAO.findById(theId);
    }

    @Override
    @Transactional
    public Customer save(Customer theCustomer) {
        return customerDAO.save(theCustomer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerDAO.deleteById(theId);

    }
}
