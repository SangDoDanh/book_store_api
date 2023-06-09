package com.luvina.bookstore.controller;


import com.luvina.bookstore.dto.BookDTO;
import com.luvina.bookstore.dto.CustomerDTO;
import com.luvina.bookstore.dto.OrdersDTO;
import com.luvina.bookstore.dto.OrdersDetailDTO;
import com.luvina.bookstore.model.Book;
import com.luvina.bookstore.model.Customer;
import com.luvina.bookstore.model.Orders;
import com.luvina.bookstore.model.OrdersDetail;
import com.luvina.bookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/orders")
public class OrdersRestController {

    @Autowired
    private IOrdersService ordersService;

    @Autowired
    IBookService bookService;

    @Autowired
    IOrdersDetailService ordersDetailService;

    @Autowired
    ICustomerService customerService;

    @Autowired
    IMapper mapper;

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

    @PutMapping("/cus/{idCustomer}")
    public ResponseEntity<?> payBook(@PathVariable Long idCustomer, @RequestBody BookDTO bookDTO) {

        if(idCustomer == null)
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CustomerDTO customerDTO = customerService.getCusById(idCustomer);

        if(customerDTO == null)
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if(bookDTO == null) {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Book book = mapper.toBook(bookDTO);
        book.setIsRemove(false);

        DateTimeFormatter dateFm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Orders orders = new Orders(null, false, LocalDate.now().format(dateFm), null, null);
        orders = ordersService.save(orders);

        OrdersDetail ordersDetail = new OrdersDetail(null, false, 1, book, orders);

        ordersDetailService.save(ordersDetail);


        ordersService.updateCustomer(orders.getId(), idCustomer);
        int quantityBook = Integer.parseInt(book.getQuantity()) - 1;

        if(quantityBook <= 0) {
            book.setQuantity("0");
            bookService.upDateQuantity(book.getId(), 0);
        } else {
            book.setQuantity("" + quantityBook);
            bookService.upDateQuantity(book.getId(), quantityBook);
        }

        return  new ResponseEntity<>(mapper.toBookDTO(book), HttpStatus.OK);

    }


}
