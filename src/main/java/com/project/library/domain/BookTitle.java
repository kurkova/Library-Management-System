package com.project.library.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity(name = "bookTitles")
public class BookTitle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "author")
    private String author;

    @NotNull
    @Column(name = "yearOfPublication")
    private int yearOfPublication;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "bookTitleId",
            fetch = FetchType.EAGER
    )
    private List<Book> books;
}
