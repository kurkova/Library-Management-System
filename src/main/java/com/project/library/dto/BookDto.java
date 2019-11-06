package com.project.library.dto;

import com.project.library.domain.BookStatus;
import com.project.library.domain.BookTitle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDto {
    private Long id;
    private Long bookTitleId;
    private BookStatus bookStatusId;
    private List<BookHireDto> bookHires;


}
