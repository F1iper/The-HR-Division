package com.thehrdivision.service.impl;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.entities.Employee;
import com.thehrdivision.mapper.EmployeeMapper;
import com.thehrdivision.repository.EmployeeRepository;
import com.thehrdivision.service.EmployeeUpdateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeUpdateServiceImpl implements EmployeeUpdateService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public boolean updateSuccessfull(EmployeeDto dto, Integer id) {
        if (repository.existsById(id)) {
            Employee employee = mapper.toEmployee(dto);
            employee.setId(id);
            repository.save(employee);
            return true;
        }
        return false;
    }
}