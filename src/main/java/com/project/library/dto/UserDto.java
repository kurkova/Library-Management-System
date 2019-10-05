package com.project.library.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
//@AllArgsConstructor
@Data
public class UserDto {
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getCreatedAccount() {
        return createdAccount;
    }

    private Long id;
    private String name;
    private String lastName;
    private LocalDate createdAccount;

    public UserDto(Long id, String name, String lastName, LocalDate createdAccount) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.createdAccount = createdAccount;
    }
}




