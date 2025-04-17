package com.dk.departmentservice.service.impl;

import com.dk.departmentservice.dto.DepartmentDto;
import com.dk.departmentservice.entity.Department;
import com.dk.departmentservice.exception.ResourceNotFoundException;
import com.dk.departmentservice.repository.DepartmentRepository;
import com.dk.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    private ModelMapper mapper;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        Department department = mapper.map(departmentDto,Department.class);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto =  mapper.map(savedDepartment,DepartmentDto.class);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartment(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode).orElseThrow(
                () -> new ResourceNotFoundException("Department","DepartmentCode",departmentCode)
        );

        DepartmentDto departmentDto = mapper.map(department,DepartmentDto.class);

        return departmentDto;

    }
}
