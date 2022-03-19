package com.thehrdivision.service.impl;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.entities.Employee;
import com.thehrdivision.mapper.EmployeeMapper;
import com.thehrdivision.repository.EmployeeRepository;
import com.thehrdivision.service.EmployeeGetAsList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeGetAsListImpl implements EmployeeGetAsList {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public List<Employee> employeesAsList() {
        List<EmployeeDto> employeeDtos = mapper.listToListDto(repository.findAll());
        return mapper.listDtoToList(employeeDtos);
    }

    @Override
    public List<EmployeeDto> employeesDtoAsList() {
        List<Employee> employees = repository.findAll();
        return mapper.listToListDto(employees);
    }
}
