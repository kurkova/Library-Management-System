package com.project.library.dto;

        import com.project.library.domain.BookCopy;
        import com.project.library.domain.User;
        import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.Getter;

        import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Data
public class BookHireDto {
    private Long id;
    private User userId;
    private BookCopy bookCopyId;
    private LocalDate rentalDate;
    private LocalDate returnDate;
}
