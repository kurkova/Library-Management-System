package com.project.library.dto;

import com.project.library.domain.BookStatus;
import com.project.library.domain.BookTitle;
import com.project.library.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookCopyDto {
    private Long id;
    private BookTitle bookTitleId;
    private BookStatus bookStatusId;
}
