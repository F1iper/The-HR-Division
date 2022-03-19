package com.thehrdivision.entities;

import javax.persistence.*;

@Entity
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Person person;


}