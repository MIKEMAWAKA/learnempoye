package com.course.learnempoye.controller;


import com.course.learnempoye.dto.EmployeeDto;
import com.course.learnempoye.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
//@AllArgsConstructor
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody  EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        return  new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }

    //build get employee by id
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDto> getEmployeebyid(@PathVariable("id")
                                                       Long employeeid){
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeid);
        return  ResponseEntity.ok(employeeDto);
    }

    //Build Get All Employee Rest API
    @GetMapping
    public  ResponseEntity<List<EmployeeDto>> getAllEmployees(){
       List<EmployeeDto> employees = employeeService.getAllEmployees();

       return ResponseEntity.ok(employees);
    }


    //Get updated
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updadetemployee(@PathVariable("id")
                                                       Long employeeid,@RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeid,updatedEmployee);

        return  ResponseEntity.ok(employeeDto);
    }

    //deletemployee

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id")
                                                       Long employeeid){
        employeeService.deleteEmployee(employeeid);

        return  ResponseEntity.ok("Employee deleted successfully");
    }

}
