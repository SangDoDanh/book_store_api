package com.luvina.bookstore.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_remove")
    private Boolean isRemove;

    private String title;

    private String quantity;

    private Double price;

    private String description;

    private String image;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private BookType type;

    @OneToMany(mappedBy = "book")
    private Set<OrdersDetail> ordersDetails;
}
