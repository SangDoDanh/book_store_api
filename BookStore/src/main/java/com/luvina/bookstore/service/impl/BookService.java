package com.luvina.bookstore.service.impl;

import com.luvina.bookstore.model.Book;
import com.luvina.bookstore.repository.IBookRepository;
import com.luvina.bookstore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;
    @Override
    public List<Book> getAll() {

        return bookRepository.getAll();
    }

    @Override
    public Optional<Book> getBookById(Long id) {

        return bookRepository.getBookById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public boolean existsById(Long id) {
        return  bookRepository.existsById(id);
    }

    @Override
    public void removeBookById(Long id) {
        bookRepository.removeBookById(id);
    }

    @Override
    public void upDateQuantity(Long id, int quantityBook) {
        bookRepository.upDateQuantity(id, quantityBook);
    }
}
