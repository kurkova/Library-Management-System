package com.project.library.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
@Entity(name = "book_hires")
public class BookHire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book bookId;

    @NotNull
    @Column(name = "rental_date")
    private LocalDate rentalDate;

    @NotNull
    @Column(name = "return_date")
    private LocalDate returnDate;

}
