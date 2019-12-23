package com.senlainc.training.backend.domain;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "cards", schema = "bookstore")
@JsonAutoDetect
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
class Card implements Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            columnDefinition = "BIGINT"
    )
    private Long id;

    private Long number;

    @Column(name = "expiration_date")
    private LocalDate dateExpiration;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Card() {
    }

    public Card(Long number, LocalDate dateExpiration, String firstName, String lastName, Customer customer) {
        this.number = number;
        this.dateExpiration = dateExpiration;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customer = customer;
    }
}
