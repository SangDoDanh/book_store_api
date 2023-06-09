package com.luvina.bookstore.service.impl;

import com.luvina.bookstore.dto.BookDTO;
import com.luvina.bookstore.dto.OrdersDTO;
import com.luvina.bookstore.model.Customer;
import com.luvina.bookstore.model.Orders;
import com.luvina.bookstore.repository.IOrdersRepository;
import com.luvina.bookstore.service.ICustomerService;
import com.luvina.bookstore.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrdersService {
    @Autowired
    private IOrdersRepository ordersRepository;

    @Autowired
    private ICustomerService customerService;
    @Override
    public List<OrdersDTO> getAllOrdersByCusId(Long id) {
        return ordersRepository.getAllOrdersByCusId(id);
    }

    @Override
    public Orders save(Orders orders) {

        return ordersRepository.save(orders);
    }

    @Override
    public void updateCustomer(Long id, Long idCustomer) {
        ordersRepository.updateCustomer(id, idCustomer);
    }

}
