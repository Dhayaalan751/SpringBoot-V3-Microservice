package com.dk.departmentservice.controller;

import com.dk.departmentservice.dto.DepartmentDto;
import com.dk.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    // Build save department REST API
    @PostMapping
    public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto){
        DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    // Build get department REST API
    @GetMapping("{department-code}")
    public ResponseEntity<DepartmentDto> getDepartment(@PathVariable("department-code") String departmentCode){
        DepartmentDto departmentDto = departmentService.getDepartment(departmentCode);
        return new ResponseEntity<>(departmentDto,HttpStatus.OK);
    }
}
