package com.luvina.bookstore.repository;

import com.luvina.bookstore.model.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersDetailRepository extends JpaRepository<OrdersDetail, Long> {
}
