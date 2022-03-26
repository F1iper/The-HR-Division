package com.thehrdivision.mapper.impl;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.entities.Employee;
import com.thehrdivision.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeMapperImpl implements EmployeeMapper {

    private final ModelMapper mapper;

    @Override
    public EmployeeDto toEmployeeDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        mapper.map(employee, employeeDto);
        return employeeDto;
    }

    @Override
    public List<EmployeeDto> listToListDto(List<Employee> employees) {
        if (employees.isEmpty())
            return null;
        else {
            List<EmployeeDto> dtos = new ArrayList<>();
            for (Employee employee : employees) {
                dtos.add(toEmployeeDto(employee));
            }
            return dtos;
        }
    }

    @Override
    public List<Employee> listDtoToList(List<EmployeeDto> dtos) {
        if (dtos.isEmpty())
            return null;
        else {
            List<Employee> employees = new ArrayList<>();
            for (EmployeeDto employeeDto : dtos) {
                employees.add(toEmployee(employeeDto));
            }
            return employees;
        }
    }

    @Override
    public Employee toEmployee(EmployeeDto dto) {
        Employee employee = new Employee();
        mapper.map(dto, employee);
        return employee;
    }
}
