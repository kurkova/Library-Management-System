package com.project.library.dto;
import com.project.library.domain.BookStatus;
import lombok.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private Long id;
    private Long bookTitle;
    private BookStatus bookStatusId;
    private List<BookHireDto> bookHires;
}
