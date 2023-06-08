package com.luvina.bookstore.controller;

import com.luvina.bookstore.dto.BookDTO;
import com.luvina.bookstore.model.Book;
import com.luvina.bookstore.service.IBookService;
import com.luvina.bookstore.service.IMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/books")
public class BookRestController {

    @Autowired
    private IMapper mapper;

    @Autowired
    private IBookService bookService;


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Book> books = bookService.getAll();
        if(books.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        List<BookDTO> bookDTOS = mapper.toListBookDTO(books);

        return new ResponseEntity<>(bookDTOS, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        Optional<Book> optionalBook = bookService.getBookById(id);

        if(optionalBook.isPresent()) {
            return new ResponseEntity<>(mapper.toBookDTO(optionalBook.get()), HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable Long id) {
        return bookService.existsById(id);
    }

    @PostMapping()
    public ResponseEntity<?> addBook(@RequestBody BookDTO bookDTO) {
        if(bookDTO == null)
            return new ResponseEntity<>("not add book", HttpStatus.NOT_FOUND);
        Book book = mapper.toBook(bookDTO);
        book.setIsRemove(false);
        book = bookService.save(book);
        return new ResponseEntity<>(mapper.toBookDTO(book), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@RequestBody BookDTO bookDTO, @PathVariable Long id) {
        if(id == null) {
            return new ResponseEntity<>("not found", HttpStatus.NO_CONTENT);
        }

        if(existsById(id)) {
            bookDTO.setId(id);
            return addBook(bookDTO);
        }

        return new ResponseEntity<>("not found", HttpStatus.NOT_FOUND);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
        if(id == null)
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        if(existsById(id)) {
            bookService.removeBookById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>("remove not ok", HttpStatus.NOT_MODIFIED);
    }

}
