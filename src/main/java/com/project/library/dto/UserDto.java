package com.project.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate createdAccount;
    private List<BookHireDto> bookHires;

}




