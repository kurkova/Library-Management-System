package com.project.library.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
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
            targetEntity = BookCopy.class,
            mappedBy = "bookTitleId",
            fetch = FetchType.EAGER
    )
    private List<BookCopy> books = new ArrayList<>();
}
