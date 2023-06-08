package com.luvina.bookstore.repository;

import com.luvina.bookstore.model.BookType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ITypeRepository extends JpaRepository<BookType, Long> {
}
