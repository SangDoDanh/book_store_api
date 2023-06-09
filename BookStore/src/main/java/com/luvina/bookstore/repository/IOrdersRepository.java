package com.luvina.bookstore.repository;


import com.luvina.bookstore.dto.OrdersDTO;
import com.luvina.bookstore.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Long> {

    @Query(nativeQuery = true,
    value = "SELECT\n" +
            "\to.id AS ordersId,\n" +
            "\tc.id AS customerId,\n" +
            "\tb.image,\n" +
            "\tb.title,\n" +
            "\tod.id as orderDetailId,\n" +
            "\to.orders_date AS ordersDate,\n" +
            "\tb.id AS bookId,\n" +
            "\tb.price,\n" +
            "\tod.quantity,\n" +
            "\t(od.quantity * b.price) AS total\n" +
            "FROM\n" +
            "\torders o\n" +
            "\tJOIN orders_detail od ON o.id = od.orders_id\n" +
            "\tJOIN book b ON b.id = od.book_id\n" +
            "\tJOIN customer c ON c.id = o.customer_id \n" +
            "WHERE\n" +
            "\tc.id = :id " +
            "AND od.is_remove = false " +
            "AND c.is_remove = false " +
            "AND o.is_remove = false " +
            "AND b.is_remove = false")
    List<OrdersDTO> getAllOrdersByCusId(@Param("id") Long id);
}
