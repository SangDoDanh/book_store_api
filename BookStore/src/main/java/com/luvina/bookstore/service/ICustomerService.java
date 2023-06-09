package com.luvina.bookstore.service;

import com.luvina.bookstore.dto.CustomerDTO;
import com.luvina.bookstore.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> getAllCustomerHasOrders();

    List<CustomerDTO> getAll();

    CustomerDTO getCusById(Long id);

    Customer findById(Long idCustomer);
}
