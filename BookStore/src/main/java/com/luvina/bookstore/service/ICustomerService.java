package com.luvina.bookstore.service;

import com.luvina.bookstore.dto.CustomerDTO;

import java.util.List;

public interface ICustomerService {
    List<CustomerDTO> getAllCustomerHasOrders();
}
