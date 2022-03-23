package com.thehrdivision.controllers;


import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeGetAsList getAsList;
    private final EmployeeGetByIdService getById;
    private final EmployeeAddService add;
    private final EmployeeUpdateService update;
    private final EmployeeRemoveService remove;


    @GetMapping
    public ResponseEntity<List<?>> findAsList() {
        if (getAsList.isNotEmpty())
            return new ResponseEntity<>(getAsList.employeesDtoAsList(), HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        if (getById.exists(id))
            return new ResponseEntity<>(getById.find(id), HttpStatus.FOUND);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody final EmployeeDto dto) {
        return new ResponseEntity<>(add.execute(dto), HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody final EmployeeDto dto, @PathVariable Integer id) {
        if (update.successfull(dto, id))
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping
    public ResponseEntity<?> removeAll() {
        if (remove.successfull())
            return new ResponseEntity<>(HttpStatus.GONE);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeById(@PathVariable Integer id) {
        if (remove.successfull(id))
            return new ResponseEntity<>(HttpStatus.GONE);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
