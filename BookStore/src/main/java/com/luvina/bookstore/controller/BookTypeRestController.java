package com.luvina.bookstore.controller;


import com.luvina.bookstore.model.BookType;
import com.luvina.bookstore.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/types")
public class BookTypeRestController {

    @Autowired
    private IBookTypeService typeService;

    @GetMapping
    public ResponseEntity<?> getAllTypes() {
        List<BookType> bookTypes = typeService.findAll();
        return new ResponseEntity<>(bookTypes, HttpStatus.OK);
    }
}
