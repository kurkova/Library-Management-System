package com.project.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookTitleDto {
    private Long id;
    private String title;
    private String author;
    private  int yearOfPublication;
}
