package com.luvina.bookstore.service;

import com.luvina.bookstore.model.BookType;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBookTypeService {
    List<BookType> findAll();
}
