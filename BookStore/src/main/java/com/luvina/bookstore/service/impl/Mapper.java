package com.luvina.bookstore.service.impl;

import com.luvina.bookstore.dto.BookDTO;
import com.luvina.bookstore.model.Book;
import com.luvina.bookstore.model.BookType;
import com.luvina.bookstore.service.IMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Mapper implements IMapper {
    @Override
    public List<BookDTO> toListBookDTO(List<Book> books) {
        List<BookDTO> bookDTOS = new ArrayList<>();

        for(Book book : books) {
            BookDTO bookDTO = new BookDTO();
            bookDTO.setId(book.getId());
            bookDTO.setTitle(book.getTitle());
            bookDTO.setQuantity(book.getQuantity());
            bookDTO.setPrice(book.getPrice());
            bookDTO.setDescription(book.getDescription());
            bookDTO.setImage(book.getImage());
            bookDTO.setType(book.getType());
            bookDTOS.add(bookDTO);
        }
        return bookDTOS;
    }

    @Override
    public BookDTO toBookDTO(Book book) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setId(book.getId());
        bookDTO.setTitle(book.getTitle());
        bookDTO.setQuantity(book.getQuantity());
        bookDTO.setPrice(book.getPrice());
        bookDTO.setDescription(book.getDescription());
        bookDTO.setImage(book.getImage());
        bookDTO.setType(book.getType());

        return bookDTO;
    }

    @Override
    public Book toBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setId(bookDTO.getId());
        book.setTitle(bookDTO.getTitle());
        book.setQuantity(bookDTO.getQuantity());
        book.setPrice(bookDTO.getPrice());
        book.setDescription(bookDTO.getDescription());
        book.setImage(bookDTO.getImage());
        book.setType(bookDTO.getType());

        return book;
    }
}
