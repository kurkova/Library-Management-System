package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "title_id")
    private BookTitle bookTitleId;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @OneToMany(
            targetEntity = BookHire.class,
            mappedBy = "bookId",
            fetch = FetchType.EAGER
    )
    private List<BookHire> bookHires;

}

