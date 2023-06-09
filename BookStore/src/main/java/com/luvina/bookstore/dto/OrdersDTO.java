package com.luvina.bookstore.dto;

public interface OrdersDTO {

    Long getOrdersId();
    Long getCustomerId();
    String getImage();
    String getTitle();
    String getOrdersDate();
    Long getOrderDetailId();
    Long getBookId();
    Double getPrice();
    Integer getQuantity();
    Double getTotal();

}
