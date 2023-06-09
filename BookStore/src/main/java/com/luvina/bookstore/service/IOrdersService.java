package com.luvina.bookstore.service;

import com.luvina.bookstore.dto.OrdersDTO;

import java.util.List;

public interface IOrdersService {
    List<OrdersDTO> getAllOrdersByCusId(Long id);
}
