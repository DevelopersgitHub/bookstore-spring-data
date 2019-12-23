package com.senlainc.training.backend.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customers", schema = "bookstore")
@JsonAutoDetect
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Customer implements Serializable {

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

    @OneToMany
    @JoinColumn(name = "number")
    private List<Card> cards;

    private String login;
    private String password;

    @OneToMany
    @JoinColumn(name = "id")
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String firstName, String lastName, List<Card> cards, String login, String password, List<Order> orders) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cards = cards;
        this.login = login;
        this.password = password;
        this.orders = orders;
    }
}
