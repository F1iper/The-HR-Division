package com.thehrdivision.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="MM/dd/yyyy")
    private LocalDate dateOfBirth;
    @JsonFormat(pattern="MM/dd/yyyy")
    private LocalDate dateJoined;
    private LocalDate dateLeft;
    private Boolean disability;

}
