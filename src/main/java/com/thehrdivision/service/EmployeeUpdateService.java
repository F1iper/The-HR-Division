package com.thehrdivision.service;

import com.thehrdivision.dto.EmployeeDto;

public interface EmployeeUpdateService {


    boolean updateSuccessfull(EmployeeDto dto, Integer id);
}
