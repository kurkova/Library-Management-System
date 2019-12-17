package com.project.library.dto;
import lombok.*;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookTitleDto {
    private Long id;
    private String title;
    private String author;
    private  int yearOfPublication;
    private List<BookDto> booksCopy;
}
