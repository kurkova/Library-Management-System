package com.project.library.domain;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name ="id")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "title_id")
    private BookTitle bookTitle;

    @NotNull
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;

    @OneToMany(
            targetEntity = com.project.library.domain.BookHire.class,
            mappedBy = "book",
            fetch = FetchType.EAGER
    )
    private List<BookHire> bookHires;
}
