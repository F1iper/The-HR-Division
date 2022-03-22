package com.thehrdivision.controllers;


import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.repository.EmployeeRepository;
import com.thehrdivision.service.EmployeeAddService;
import com.thehrdivision.service.EmployeeGetAsList;
import com.thehrdivision.service.EmployeeGetByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;


@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeAddService add;
    private final EmployeeGetAsList getAsList;
    private final EmployeeGetByIdService getById;
    //    private final EmployeeUpdateService update;
//    private final EmployeeDeleteAllService deleteAll;
    private final EmployeeRepository repository;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll() {
//        if (getAsList.isNotEmpty()) todo: fix n+1 problem caused by app implementation
            return new ResponseEntity<>(getAsList.employeesDtoAsList(), FOUND);
//        return new ResponseEntity<>(NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable Integer id) {
        if (getById.exists(id))
            return new ResponseEntity<>(getById.find(id), FOUND);
        return new ResponseEntity<>(NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> addEmployee(@RequestBody EmployeeDto dto) {
        return new ResponseEntity<>(add.execute(dto), CREATED);
    }

    @DeleteMapping()
    public ResponseEntity deleteAll() {
        repository.deleteAll();
        return new ResponseEntity(ACCEPTED);
    }
}
