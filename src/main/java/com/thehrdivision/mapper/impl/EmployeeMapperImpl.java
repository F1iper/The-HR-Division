package com.thehrdivision.mapper.impl;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.entities.Employee;
import com.thehrdivision.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeDto toDto(Employee employee) {
        if (employee == null)
            return null;
        else {
            EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.setId(employee.getId());
            employeeDto.setFirstname(employee.getFirstname());
            employeeDto.setLastname(employee.getLastname());
            employeeDto.setDateOfBirth(employee.getDateOfBirth());
            employeeDto.setDisability(employee.getDisability());
            employeeDto.setDateJoined(employee.getDateJoined());
            employeeDto.setDateLeft(employee.getDateLeft());
            employeeDto.setGender(employee.getGender());
            return employeeDto;
        }
    }

    @Override
    public List<EmployeeDto> listToListDto(List<Employee> employees) {
        if (employees.isEmpty())
            return null;
        else {
            List<EmployeeDto> dtos = new ArrayList<>();
            for (Employee employee : employees) {
                dtos.add(toDto(employee));
            }
            return dtos;
        }
    }

    @Override
    public List<Employee> listDtoToList(List<EmployeeDto> dtos) {
        if (dtos.isEmpty())
            return null;
        else {
            List<Employee> employees = new ArrayList<>();
            for (EmployeeDto employeeDto : dtos) {
                employees.add(fromDto(employeeDto));
            }
            return employees;
        }
    }

    @Override
    public Employee fromDto(EmployeeDto dto) {
        if (dto == null)
            return null;
        else {

            Employee employee = new Employee();
            employee.setId(dto.getId());
            employee.setFirstname(dto.getFirstname());
            employee.setLastname(dto.getLastname());
            employee.setDateOfBirth(dto.getDateOfBirth());
            employee.setDisability(dto.getDisability());
            employee.setDateJoined(dto.getDateJoined());
            employee.setDateLeft(dto.getDateLeft());
            employee.setGender(dto.getGender());
            return employee;
        }
    }
}
