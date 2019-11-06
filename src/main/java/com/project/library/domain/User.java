package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "lastName")
    private String lastName;

    @NotNull
    @Column (name = "createdAccountData")
    private LocalDate createdAccount;

    @OneToMany(
            targetEntity = BookHire.class,
            mappedBy = "userId",
            fetch = FetchType.EAGER
    )
    private List<BookHire> booksHire;

}
