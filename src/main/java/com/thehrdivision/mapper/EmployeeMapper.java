package com.thehrdivision.mapper;

import com.thehrdivision.dto.EmployeeDto;
import com.thehrdivision.entities.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee fromDto(EmployeeDto dto);

    List<EmployeeDto> listToListDto(List<Employee> employees);

    List<Employee> listDtoToList(List<EmployeeDto> dtos);
}
