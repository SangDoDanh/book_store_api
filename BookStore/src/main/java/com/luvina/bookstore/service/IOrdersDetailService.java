package com.luvina.bookstore.service;

import com.luvina.bookstore.dto.OrdersDetailDTO;
import com.luvina.bookstore.model.OrdersDetail;

import java.util.Optional;

public interface IOrdersDetailService {
    Optional<OrdersDetail> findById(Long orderDetailId);

    OrdersDetail save(OrdersDetail od);

    OrdersDetailDTO getOrdersDetailById(Long orderDetailId);

    void upQuantity(Integer quantity, Long id);

    void deleteOrdersDetail(Long id);
}
