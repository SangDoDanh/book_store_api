package com.luvina.bookstore.repository;

import com.luvina.bookstore.dto.BookDTO;
import com.luvina.bookstore.dto.OrdersDetailDTO;
import com.luvina.bookstore.model.OrdersDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface IOrdersDetailRepository extends JpaRepository<OrdersDetail, Long> {


    @Query(nativeQuery = true,
            value = "SELECT od.id, od.quantity, (od.quantity * b.price) as total \n" +
                    "\tFROM orders_detail od join book b on b.id = od.book_id \n" +
                    "\tWHERE od.id = :id AND od.is_remove = FALSE")
    OrdersDetailDTO getOrdersDetailById(@Param("id") Long orderDetailId);

    @Query(nativeQuery = true,
            value = "UPDATE orders_detail\n" +
                    "\tSET quantity = :q\n" +
                    "\tWHERE id = :id")
    @Modifying
    void upQuantity(@Param("q") Integer quantity, @Param("id") Long id);

    @Query(nativeQuery = true,
            value = "UPDATE orders_detail\n" +
                    "\tSET is_remove = true\n" +
                    "\tWHERE id = :id")
    @Modifying
    void deleteOrdersDetail(@Param("id") Long id);

}
