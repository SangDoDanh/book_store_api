package com.luvina.bookstore.dto;

import com.luvina.bookstore.model.BookType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDTO {

    private Long id;

    private String title;

    private String quantity;

    private Double price;

    private String description;

    private String image;

    private BookType type;

}
