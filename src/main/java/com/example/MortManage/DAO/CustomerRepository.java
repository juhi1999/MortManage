package com.example.MortManage.DAO;

import com.example.MortManage.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    //that's it.. no need to write any code
}
