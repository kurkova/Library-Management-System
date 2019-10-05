package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
//@AllArgsConstructor
@Data
@Entity(name = "users")
public class User {
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getCreatedAccount() {
        return createdAccount;
    }

    public User(Long id, String name, String lastName, LocalDate createdAccount) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.createdAccount = createdAccount;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column (name = "createdAccountData")
    private LocalDate createdAccount;


}
