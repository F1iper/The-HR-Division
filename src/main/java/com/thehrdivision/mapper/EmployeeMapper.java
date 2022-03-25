package com.thehrdivision.mapper;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.entities.Employee;

import java.util.List;

public interface EmployeeMapper {

    EmployeeDto toEmployeeDto(Employee employee);

    Employee toEmployee(EmployeeDto dto);

    List<EmployeeDto> listToListDto(List<Employee> employees);

    List<Employee> listDtoToList(List<EmployeeDto> dtos);
}
