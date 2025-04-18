package com.dk.employeeservice.service.impl;

import com.dk.employeeservice.dto.APIResponseDto;
import com.dk.employeeservice.dto.DepartmentDto;
import com.dk.employeeservice.dto.EmployeeDto;
import com.dk.employeeservice.dto.OrganizationDto;
import com.dk.employeeservice.entity.Employee;
import com.dk.employeeservice.exception.EmailAlreadyExistsException;
import com.dk.employeeservice.repository.EmployeeRepository;
import com.dk.employeeservice.service.APIClient;
import com.dk.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    private ModelMapper mapper;

    private APIClient apiClient;

    private WebClient webClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Optional<Employee> employeeOptional = employeeRepository.findByEmail(employeeDto.getEmail());

        if (employeeOptional.isPresent()) {
            throw new EmailAlreadyExistsException("Email Already Exists for Employee");
        }

        Employee employee = mapper.map(employeeDto, Employee.class);

        Employee savedEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = mapper.map(savedEmployee, EmployeeDto.class);

        return savedEmployeeDto;
    }

    @Override
    public APIResponseDto getEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).get();

        ResponseEntity<DepartmentDto> departmentDto = apiClient.getDepartment(employee.getDepartmentCode());

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        EmployeeDto employeeDto = mapper.map(employee, EmployeeDto.class);

        APIResponseDto apiResponseDto = new APIResponseDto(
                employeeDto,
                departmentDto.getBody(),
                organizationDto
        );
        return apiResponseDto;

    }
}
