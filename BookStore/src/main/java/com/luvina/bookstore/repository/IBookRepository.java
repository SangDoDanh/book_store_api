package com.luvina.bookstore.repository;

import com.luvina.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface IBookRepository extends JpaRepository<Book, Long> {
    @Query(nativeQuery = true, value = "SELECT * from book where  is_remove = false")
    List<Book> getAll();

    @Query(nativeQuery = true, value = "SELECT * from book where  is_remove = false and id = :id")
    Optional<Book> getBookById(@Param("id") Long id);


    @Modifying
    @Query(nativeQuery = true, value = "UPDATE book set is_remove = true where id = :id")
    void removeBookById(@Param("id") Long id);
}
