package com.project.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BookTitleDto {
    private Long id;
    private String title;
    private String author;
    private  int yearOfPublication;
    private List<BookCopyDto> booksCopy;
}
