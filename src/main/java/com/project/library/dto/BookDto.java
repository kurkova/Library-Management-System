package com.project.library.dto;

import com.project.library.domain.BookStatus;
import com.project.library.domain.BookTitle;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class BookDto {
    private Long id;
    private BookTitle bookTitleId;
    private BookStatus bookStatusId;
    private List<BookHireDto> bookHires;
}
