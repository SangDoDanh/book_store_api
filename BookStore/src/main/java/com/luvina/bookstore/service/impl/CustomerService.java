package com.luvina.bookstore.service.impl;

import com.luvina.bookstore.dto.CustomerDTO;
import com.luvina.bookstore.model.Customer;
import com.luvina.bookstore.repository.ICustomerRepository;
import com.luvina.bookstore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public List<CustomerDTO> getAllCustomerHasOrders() {

        return customerRepository.getAllCustomerHasOrders();
    }

    @Override
    public List<CustomerDTO> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public CustomerDTO getCusById(Long id) {
        return customerRepository.getCusById(id);
    }

    @Override
    public Customer findById(Long idCustomer) {
        Optional<Customer> customerOptional = customerRepository.findById(idCustomer);
        return customerOptional.orElse(null);
    }
}
