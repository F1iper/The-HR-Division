package com.thehrdivision;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private String login;
    @NotNull
    private String password;
    private String workEmail;
    @OneToOne()
    @JoinColumn(name = "position_id")
    private Position position;
    private Date createdAt;
    private Date updatedAt;
    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
