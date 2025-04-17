package com.dk.employeeservice.service;

import com.dk.employeeservice.dto.APIResponseDto;
import com.dk.employeeservice.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployee(Long EmployeeId);
}
