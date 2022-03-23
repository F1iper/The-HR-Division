package com.thehrdivision.service;

import com.thehrdivision.dto.EmployeeDto;

public interface EmployeeUpdateService {


    boolean successfull(EmployeeDto dto, Integer id);
}
