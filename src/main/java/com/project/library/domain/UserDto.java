package com.project.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
//    private LocalDate createdAccount;
}
