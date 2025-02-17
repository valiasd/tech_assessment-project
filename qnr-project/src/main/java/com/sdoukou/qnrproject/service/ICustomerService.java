package com.sdoukou.qnrproject.service;

import com.sdoukou.qnrproject.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAllCustomers() throws Exception;
}
