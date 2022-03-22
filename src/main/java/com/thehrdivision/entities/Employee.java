package com.thehrdivision.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String firstname;
    private String lastname;
    private String gender;
    private LocalDate dateOfBirth;
    private LocalDate dateJoined;
    private LocalDate dateLeft;
    private Boolean disability;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Person user;

    @OneToMany(mappedBy = "employee")
    private Set<TrainingHistory> trainingHistory;

    @OneToMany(mappedBy = "employee")
    private Set<PerformanceReview> performanceReviews;

    @OneToMany(mappedBy = "employee")
    private Set<Payroll> payrolls;

    @OneToMany(mappedBy = "employee")
    private Set<EmployeeSkills> employeeSkills;

    @OneToMany(mappedBy = "employee")
    private Set<JobAssigments> jobAssigments;

}
