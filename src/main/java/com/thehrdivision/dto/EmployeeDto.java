package com.thehrdivision.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class EmployeeDto {

    private Integer id;

    private String firstname;
    private String lastname;
    private String gender;
    private LocalDate dateOfBirth;
    private LocalDate dateJoined;
    private LocalDate dateLeft;
    private Boolean disability;

}
