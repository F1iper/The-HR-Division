package com.thehrdivision;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.Date;

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

    public UserEntity() {
    }

    public UserEntity(int id, String login, String password, String workEmail, Position position, Date createdAt, Date updatedAt, Employee employee) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.workEmail = workEmail;
        this.position = position;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.employee = employee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
