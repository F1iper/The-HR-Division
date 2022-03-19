package com.thehrdivision.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class EmployeeSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate skillAquiredDate;

    @ManyToOne
    private Employee employee;
}
