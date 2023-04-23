package com.example.MortManage.DAO;

import com.example.MortManage.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    private EntityManager entityManager;

    @Autowired
    public CustomerDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Customer save(Customer theCustomer) {

        //save customer //save or update depends on id= 0 or not
       Customer dbCustomer= entityManager.merge(theCustomer);

        //return the customer updated.
        return dbCustomer;
    }

    @Override
    public void deleteById(int theId) {

        //find the customer
        Customer theCustomer=entityManager.find(Customer.class,theId);
        //remove employee
        entityManager.remove(theCustomer);

    }

    @Override
    public List<Customer> FindAll() {
        //create a query
        TypedQuery<Customer> theQuery= entityManager.createQuery("from Customer",Customer.class);

        //execute query and get result
        List<Customer> customers=theQuery.getResultList();

        //return the results
        return customers;
    }

    @Override
    public Customer findById(int theId) {

        //get Customer
        Customer theCustomer= entityManager.find(Customer.class,theId);

        return theCustomer;
    }
}
