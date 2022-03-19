package com.thehrdivision.controllers;


import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.repository.EmployeeRepository;
import com.thehrdivision.service.EmployeeAddService;
import com.thehrdivision.service.EmployeeGetAsList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeAddService addService;
    private final EmployeeGetAsList getAsList;
    private final EmployeeRepository repository;

    @GetMapping
    public List<EmployeeDto> findEmployeesAsList() {
        return getAsList.employeesDtoAsList();
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto) {
        return new ResponseEntity<>(addService.add(dto), HttpStatus.CREATED);
    }
}
