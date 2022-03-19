package com.thehrdivision.repository;

import com.thehrdivision.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
