package com.thehrdivision.service.impl;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.mapper.EmployeeMapper;
import com.thehrdivision.repository.EmployeeRepository;
import com.thehrdivision.service.EmployeeGetByIdService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeGetByIdServiceImpl implements EmployeeGetByIdService {

    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    @Override
    public EmployeeDto find(Integer id) {
        return mapper.toDto(repository.getById(id));

    }

    @Override
    public boolean exists(Integer id) {
        return repository.existsById(id);
    }
}
