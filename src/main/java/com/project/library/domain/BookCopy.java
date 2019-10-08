package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@Data
@Entity(name = "books_copy")
public class BookCopy {
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
            mappedBy = "bookCopyId",
            fetch = FetchType.EAGER
    )
    private List<BookHire> bookHires = new ArrayList<>();
}
