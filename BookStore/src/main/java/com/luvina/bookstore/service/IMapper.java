package com.luvina.bookstore.service;

import com.luvina.bookstore.dto.BookDTO;
import com.luvina.bookstore.model.Book;

import java.util.List;

public interface IMapper {
    List<BookDTO> toListBookDTO(List<Book> books);

    BookDTO toBookDTO(Book book);

    Book toBook(BookDTO bookDTO);
}
