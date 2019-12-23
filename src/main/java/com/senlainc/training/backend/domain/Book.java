package com.senlainc.training.backend.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "books", schema = "bookstore")
@JsonAutoDetect
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = "authors")
public class Book implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            columnDefinition = "BIGINT"
    )
    private int id;

    private String name;

    private double cost;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "arrival_date")
    private LocalDate arrivalDate;

    @Column(name = "in_stock", nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean inStock;

    @ManyToMany(mappedBy = "books")
    private List<Author> authors;

    @ManyToMany(mappedBy = "books")
    private List<Order> orders;

    @OneToMany(mappedBy = "book")
    private List<Request> requests;

    private String description;

    public Book() {
    }

    public Book(String name, Integer cost, LocalDate publicationDate, LocalDate arrivalDate, Boolean inStock, List<Request> requests, String description) {
        this.name = name;
        this.cost = cost;
        this.publicationDate = publicationDate;
        this.arrivalDate = arrivalDate;
        this.inStock = inStock;
        this.requests = requests;
        this.description = description;
    }
}
