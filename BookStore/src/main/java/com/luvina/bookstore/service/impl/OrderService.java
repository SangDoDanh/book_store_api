package com.luvina.bookstore.service.impl;

import com.luvina.bookstore.dto.OrdersDTO;
import com.luvina.bookstore.repository.IOrdersRepository;
import com.luvina.bookstore.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrdersService {
    @Autowired
    private IOrdersRepository ordersRepository;
    @Override
    public List<OrdersDTO> getAllOrdersByCusId(Long id) {
        return ordersRepository.getAllOrdersByCusId(id);
    }
}
