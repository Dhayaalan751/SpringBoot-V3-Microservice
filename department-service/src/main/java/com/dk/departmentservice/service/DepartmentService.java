package com.dk.departmentservice.service;

import com.dk.departmentservice.dto.DepartmentDto;

public interface DepartmentService {

    DepartmentDto saveDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartment(String departmentCode);
}
