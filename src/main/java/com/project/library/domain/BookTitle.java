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

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "yearOfPublication")
    private int yearOfPublication;

    @OneToMany(
            targetEntity = Book.class,
            mappedBy = "bookTitle",
            fetch = FetchType.EAGER
    )
    private List<Book> books;
}
