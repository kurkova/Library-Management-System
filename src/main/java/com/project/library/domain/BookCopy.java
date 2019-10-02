package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookCopy {
    private Long id;
    private Long idUser;
    private BookStatus status;
}
