package com.senlainc.training.backend.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "requests", schema = "bookstore")
@JsonAutoDetect
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Request implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            columnDefinition = "BIGINT"
    )
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Enumerated(EnumType.STRING)
    private Status status;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "request")
    private Order order;

    public Request() {
    }

    public Request(Book book, Status status) {
        this.book = book;
        this.status = status;
    }
}
