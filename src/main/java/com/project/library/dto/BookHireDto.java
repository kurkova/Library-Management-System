package com.project.library.dto;
import com.project.library.domain.Book;
import com.project.library.domain.User;
import lombok.*;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookHireDto {
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate rentalDate;
    private LocalDate returnDate;



}
