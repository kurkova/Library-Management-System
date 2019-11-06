package com.project.library.dto;
import com.project.library.domain.Book;
import com.project.library.domain.User;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class BookHireDto {
    private Long id;
    private User userId;
    private Book bookId;
    private LocalDate rentalDate;
    private LocalDate returnDate;



}
