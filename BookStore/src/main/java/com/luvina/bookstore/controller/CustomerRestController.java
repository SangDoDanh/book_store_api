package com.luvina.bookstore.controller;

import com.luvina.bookstore.dto.CustomerDTO;
import com.luvina.bookstore.dto.OrdersDTO;
import com.luvina.bookstore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/customers")
public class CustomerRestController {

    @Autowired
    private ICustomerService customerService;

    @GetMapping
    public ResponseEntity<?> getAllCustomer() {
        List<CustomerDTO> customerDTOS = customerService.getAll();
        if(customerDTOS.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }

    @GetMapping("/orders")
    public ResponseEntity<List<CustomerDTO>> getAllCustomersHasOrders() {
        List<CustomerDTO> customerDTOS = customerService.getAllCustomerHasOrders();
        if(customerDTOS.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(customerDTOS, HttpStatus.OK);
    }
}
