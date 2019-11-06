package com.project.library.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "book_hires")
public class BookHire {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;


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
