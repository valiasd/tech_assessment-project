package com.sdoukou.qnrproject.service;

import com.sdoukou.qnrproject.model.Customer;
import com.sdoukou.qnrproject.repository.CustomerRepository;
import com.sdoukou.qnrproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService{

    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers() throws Exception {
        return customerRepository.findAll();
    }
}
