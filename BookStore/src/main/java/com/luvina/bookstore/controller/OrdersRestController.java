package com.luvina.bookstore.controller;


import com.luvina.bookstore.dto.OrdersDTO;
import com.luvina.bookstore.dto.OrdersDetailDTO;
import com.luvina.bookstore.model.OrdersDetail;
import com.luvina.bookstore.service.IOrdersDetailService;
import com.luvina.bookstore.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/orders")
public class OrdersRestController {

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    IOrdersDetailService ordersDetailService;

    @GetMapping("/cus/{id}")
    public ResponseEntity<?> getAllOrdersByCusId(@PathVariable Long id) {
        List<OrdersDTO> ordersDTOS = ordersService.getAllOrdersByCusId(id);
        if(ordersDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(ordersDTOS, HttpStatus.OK);
    }

    @PutMapping("/update/od/{orderDetailId}/{quantity}")
    public ResponseEntity<?> updateQuantityOrdersDetail(@PathVariable Long orderDetailId, @PathVariable Integer quantity) {
        System.out.println("aa");
        OrdersDetailDTO od = ordersDetailService.getOrdersDetailById(orderDetailId);
        if(od != null) {
            ordersDetailService.upQuantity(quantity, od.getId());

            return new ResponseEntity<>(ordersDetailService.getOrdersDetailById(orderDetailId), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/od/{orderDetailId}")
    public ResponseEntity<?> deleteOrdersDetail(@PathVariable Long orderDetailId) {
        System.out.println("aa");
        OrdersDetailDTO od = ordersDetailService.getOrdersDetailById(orderDetailId);
        if(od != null) {
            ordersDetailService.deleteOrdersDetail(od.getId());

            return new ResponseEntity<>(od.getId(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


}
