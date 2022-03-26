package com.thehrdivision.service;

import com.thehrdivision.dto.EmployeeDto;

import java.util.List;

public interface EmployeeGetAsList {

    List<EmployeeDto> employeesDtoAsList();

    boolean isNotEmpty();
}
