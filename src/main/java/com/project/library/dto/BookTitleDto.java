package com.project.library.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
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
