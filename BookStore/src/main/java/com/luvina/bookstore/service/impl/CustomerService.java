package com.luvina.bookstore.service.impl;

import com.luvina.bookstore.dto.CustomerDTO;
import com.luvina.bookstore.repository.ICustomerRepository;
import com.luvina.bookstore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<CustomerDTO> getAllCustomerHasOrders() {

        return customerRepository.getAllCustomerHasOrders();
    }
}
