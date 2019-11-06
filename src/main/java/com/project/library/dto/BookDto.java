package com.project.library.dto;

import com.project.library.domain.BookStatus;
import com.project.library.domain.BookTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BookDto {
    private Long id;
    private BookTitle bookTitleId;
    private BookStatus bookStatusId;
    private List<BookHireDto> bookHires;

    public Long getId() {
        return id;
    }

    public BookTitle getBookTitleId() {
        return bookTitleId;
    }

    public BookStatus getBookStatusId() {
        return bookStatusId;
    }

    public List<BookHireDto> getBookHires() {
        return bookHires;
    }

}
