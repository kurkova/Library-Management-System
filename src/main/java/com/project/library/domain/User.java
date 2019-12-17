package com.project.library.domain;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
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
            mappedBy = "user",
            fetch = FetchType.EAGER
    )
    private List<BookHire> booksHire;
}
