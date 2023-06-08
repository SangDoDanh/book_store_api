package com.luvina.bookstore.service.impl;

import com.luvina.bookstore.model.BookType;
import com.luvina.bookstore.repository.ITypeRepository;
import com.luvina.bookstore.service.IBookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookTypeService implements IBookTypeService {

    @Autowired
    private ITypeRepository typeRepository;

    @Override
    public List<BookType> findAll() {
        return typeRepository.findAll();
    }
}
