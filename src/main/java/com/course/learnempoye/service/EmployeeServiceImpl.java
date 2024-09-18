package com.course.learnempoye.service;

import com.course.learnempoye.dto.EmployeeDto;
import com.course.learnempoye.entities.Employee;
import com.course.learnempoye.mapper.EmployeeMapper;
import com.course.learnempoye.repository.EmpolyeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//@AllArgsConstructor
public class EmployeeServiceImpl implements  EmployeeService{

    @Autowired
    private EmpolyeeRepository empolyeeRepository;


    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToDtoEmployee(employeeDto);

        Employee savedemp =empolyeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(savedemp);
    }
}
