package com.luvina.bookstore.repository;

import com.luvina.bookstore.dto.CustomerDTO;
import com.luvina.bookstore.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    @Query(nativeQuery = true,
    value = "\tSELECT c.id as customerId, c.`name` as customerName\n" +
            "\tFROM customer c RIGHT JOIN orders o on c.id = o.customer_id\n" +
            "\tWHERE c.is_remove = FALSE AND o.is_remove = FALSE")
    List<CustomerDTO> getAllCustomerHasOrders();
}
