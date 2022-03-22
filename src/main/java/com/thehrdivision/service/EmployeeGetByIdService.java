package com.thehrdivision.service;

import com.thehrdivision.dto.EmployeeDto;

public interface EmployeeGetByIdService {

    EmployeeDto find(Integer id);

    boolean exists(Integer id);
}
