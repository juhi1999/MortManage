package com.example.MortManage.service;

import com.example.MortManage.DAO.CustomerRepository;
import com.example.MortManage.entity.Customer;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService{

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository thecustomerRepository) {
        this.customerRepository= thecustomerRepository;
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(int theId) {
        Optional<Customer> result = customerRepository.findById(theId);

        Customer theCustomer=null;

        if(result.isPresent()){
            theCustomer=result.get();
        }
        else{
            // we didnt find the customer
            throw  new RuntimeException(("Did not find customer id -"+theId));
        }
        return theCustomer;
    }

    @Override
    @Transactional
    public Customer save(Customer theCustomer) {
        return customerRepository.save(theCustomer);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        customerRepository.deleteById(theId);

    }
}
