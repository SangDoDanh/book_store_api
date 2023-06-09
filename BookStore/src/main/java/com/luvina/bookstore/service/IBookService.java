package com.luvina.bookstore.service;

import com.luvina.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> getAll();

    Optional<Book> getBookById(Long id);

    Book save(Book book);

    boolean existsById(Long id);


    void removeBookById(Long id);

    void upDateQuantity(Long id, int quantityBook);
}
