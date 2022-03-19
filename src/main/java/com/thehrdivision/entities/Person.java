package com.thehrdivision.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

    private String workEmail;

    @OneToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @Column(nullable = false, updatable = false)
    private Timestamp createdAt;

    private Timestamp updatedAt;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
