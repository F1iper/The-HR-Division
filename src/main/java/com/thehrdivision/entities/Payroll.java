package com.thehrdivision.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Payroll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate generationDate;
    private String description;
    private BigDecimal totalAmount;

    @ManyToOne
    private Employee employee;
}
