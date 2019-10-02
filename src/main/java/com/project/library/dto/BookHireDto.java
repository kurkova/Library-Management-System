package com.project.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Data
public class BookHireDto {
    private Long id;
    private Long idUser;
    private LocalDate rentBook;
    private LocalDate returnBook;
}
