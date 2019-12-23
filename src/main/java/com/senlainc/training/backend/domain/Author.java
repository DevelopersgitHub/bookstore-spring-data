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
@Table(name = "authors", schema = "bookstore")
@JsonAutoDetect
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(exclude = "books")
public class Author implements Serializable {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            columnDefinition = "BIGINT"
    )
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    private LocalDate birthday;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "authors_books",
            joinColumns = {
                    @JoinColumn(name = "author_id", nullable = false, updatable = false)},
            inverseJoinColumns = {
                    @JoinColumn(name = "book_id", nullable = false, updatable = false)}
    )
    private List<Book> books;

    public Author() {
    }

    public Author(String firstName, String lastName, String middleName, LocalDate birthday, List<Book> books) {
        this.lastName = lastName;
        this.middleName = middleName;
        this.birthday = birthday;
        this.firstName = firstName;
        this.books = books;
    }
}
