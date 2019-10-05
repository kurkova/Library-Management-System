package com.project.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate createdAccount;
}




