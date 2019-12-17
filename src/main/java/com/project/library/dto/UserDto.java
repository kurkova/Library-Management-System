package com.project.library.dto;
import lombok.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private LocalDate createdAccount;
    private List<BookHireDto> bookHires;
}




