package com.thehrdivision.service;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.entities.Employee;

import java.util.List;

public interface EmployeeGetAsList {

    List<Employee> employeesAsList();

    List<EmployeeDto> employeesDtoAsList();
}
