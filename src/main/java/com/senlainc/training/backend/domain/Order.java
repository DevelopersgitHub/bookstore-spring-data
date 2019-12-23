package com.senlainc.training.backend.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders", schema = "bookstore")
@JsonAutoDetect
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Order implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            columnDefinition = "BIGINT"
    )
    private Long id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orders_books",
            joinColumns = {
                    @JoinColumn(name = "order_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id", nullable = false, updatable = false)}
    )
    private List<Book> books;

    @Column(name = "execution_date")
    private LocalDate executionDate;

    private double cost;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne
    private Request request;

    @ManyToOne
    private Customer customer;

    public Order() {
    }

    public Order(List<Book> books, LocalDate executionDate, Integer cost, Status status, Request request, Customer customer) {
        this.books = books;
        this.executionDate = executionDate;
        this.cost = cost;
        this.status = status;
        this.request = request;
        this.customer = customer;
    }
}
