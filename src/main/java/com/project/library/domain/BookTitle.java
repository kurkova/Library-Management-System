package com.project.library.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "bookTitles")
public class BookTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "yearOfPublication")
    private int yearOfPublication;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "bookTitleId",
            fetch = FetchType.EAGER
    )
    private List<Book> books;
}
