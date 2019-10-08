package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Data
@Entity(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "lastName")
    private String lastName;

    @Column (name = "createdAccountData")
    private LocalDate createdAccount;

    @OneToMany(
            targetEntity = BookHire.class,
            mappedBy = "userId",
            fetch = FetchType.EAGER
    )
    private List<BookHire> booksHire = new ArrayList<>();

}
