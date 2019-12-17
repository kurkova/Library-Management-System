package com.project.library.domain;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity(name = "bookTitles")
public class BookTitle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
            mappedBy = "bookTitle",
            fetch = FetchType.EAGER
    )
    private List<Book> books;
}
