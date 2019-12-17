package com.project.library.dto;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookHireDto {
    private Long id;
    private Long user;
    private Long book;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
