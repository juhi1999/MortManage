package com.example.MortManage.rest;

import com.example.MortManage.DAO.CustomerDAO;
import com.example.MortManage.entity.Customer;
import com.example.MortManage.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {


   private CustomerService customerService;
    //quick and dirty : inject employee dao


    public CustomerRestController(CustomerService theCustomerService) {
        this.customerService = theCustomerService;
    }

    @GetMapping("/customers")
    public List<Customer> AllCustomers(){
        return customerService.AllCustomers();
    }

    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId)
    {
        Customer theCustomer=customerService.findById(customerId);

        if(theCustomer==null)
        {
            throw new RuntimeException("Customer id not found - "+customerId);

        }
        return theCustomer;
    }

    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer theCustomer)
    {
        //also just in case they pass an id in json.. set it to 0
        //this is to force a save of new item..instead of upsate

        theCustomer.setId(0);
        Customer dbCustomer = customerService.save(theCustomer);
        return dbCustomer;
    }






}
