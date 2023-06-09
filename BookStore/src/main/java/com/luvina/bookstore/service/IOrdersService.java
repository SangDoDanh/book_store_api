package com.luvina.bookstore.service;

import com.luvina.bookstore.dto.BookDTO;
import com.luvina.bookstore.dto.OrdersDTO;
import com.luvina.bookstore.model.Orders;

import java.util.List;

public interface IOrdersService {
    List<OrdersDTO> getAllOrdersByCusId(Long id);

    Orders save(Orders orders);

    void updateCustomer(Long id, Long idCustomer);
}
