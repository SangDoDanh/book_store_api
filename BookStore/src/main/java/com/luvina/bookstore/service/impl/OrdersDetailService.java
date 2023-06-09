package com.luvina.bookstore.service.impl;

import com.luvina.bookstore.dto.OrdersDetailDTO;
import com.luvina.bookstore.model.OrdersDetail;
import com.luvina.bookstore.repository.IOrdersDetailRepository;
import com.luvina.bookstore.service.IOrdersDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrdersDetailService implements IOrdersDetailService {

    @Autowired

    private IOrdersDetailRepository ordersDetailRepository;
    @Override
    public Optional<OrdersDetail> findById(Long orderDetailId) {
        return ordersDetailRepository.getOrdersDetail(orderDetailId);
    }

    @Override
    public OrdersDetail save(OrdersDetail od) {
        return ordersDetailRepository.save(od);
    }

    @Override
    public OrdersDetailDTO getOrdersDetailById(Long orderDetailId) {
        return ordersDetailRepository.getOrdersDetailById(orderDetailId);
    }

    @Override
    public void upQuantity(Integer quantity, Long id) {
        ordersDetailRepository.upQuantity(quantity, id);
    }

    @Override
    public void deleteOrdersDetail(Long id) {
        ordersDetailRepository.deleteOrdersDetail(id);
    }
}
