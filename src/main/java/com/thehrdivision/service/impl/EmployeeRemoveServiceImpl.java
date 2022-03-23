package com.thehrdivision.service.impl;

import com.thehrdivision.repository.EmployeeRepository;
import com.thehrdivision.service.EmployeeRemoveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeRemoveServiceImpl implements EmployeeRemoveService {

    private final EmployeeRepository repository;

    @Override
    public boolean successfull(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean successfull() {
        if (repository.count() > 0) {
            repository.deleteAll();
            return true;
        }
        return false;
    }

    @Override
    public boolean existsById(Integer id) {
        return repository.existsById(id);
    }
}
