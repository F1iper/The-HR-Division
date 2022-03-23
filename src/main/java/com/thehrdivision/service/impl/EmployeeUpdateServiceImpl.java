package com.thehrdivision.service.impl;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.entities.Employee;
import com.thehrdivision.mapper.EmployeeMapper;
import com.thehrdivision.repository.EmployeeRepository;
import com.thehrdivision.service.EmployeeUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeUpdateServiceImpl implements EmployeeUpdateService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public boolean successfull(EmployeeDto dto, Integer id) {
        List<Employee> list = repository.findAll();
        list
                .stream()
                .map(employee -> {
                    if (employee.getId().equals(id)) {
                        Employee updatedEmployee = mapper.fromDto(dto);
                        repository.save(updatedEmployee);
                        return true;
                    }
                    return false;
                });
        return false;
    }
}