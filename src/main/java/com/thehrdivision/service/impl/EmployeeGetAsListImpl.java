package com.thehrdivision.service.impl;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.mapper.EmployeeMapper;
import com.thehrdivision.repository.EmployeeRepository;
import com.thehrdivision.service.EmployeeGetAsList;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeGetAsListImpl implements EmployeeGetAsList {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public List<EmployeeDto> employeesDtoAsList() {
        if (isNotEmpty())
            return mapper.listToListDto(repository.findAll());
        return new ArrayList<>();
    }

    @Override
    public boolean isNotEmpty() {
        return !repository.findAll().isEmpty();
    }
}
