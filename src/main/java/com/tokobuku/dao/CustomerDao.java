package com.tokobuku.dao;

import com.tokobuku.model.Customer;

import java.util.List;

public interface CustomerDao {

    void insert(Customer customer);

    Customer findByCustomerId(int custId);

    void update(Customer customer);

    void deleteByCustomerId(int custId);

    List<Customer> findAllCustomer();

}
