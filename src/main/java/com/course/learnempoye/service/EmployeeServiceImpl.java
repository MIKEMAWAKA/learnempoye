package com.course.learnempoye.service;

import com.course.learnempoye.dto.EmployeeDto;
import com.course.learnempoye.entities.Employee;
import com.course.learnempoye.exception.ResourceNotFoundException;
import com.course.learnempoye.mapper.EmployeeMapper;
import com.course.learnempoye.repository.EmpolyeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long id) {

        Employee employee = empolyeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Employee does not exist with given id : "+id));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee>  employees = empolyeeRepository.findAll();

        return employees.stream().map((employee)->EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {


        Employee employee = empolyeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee does not exist with given id : "+employeeId));
        employee.setDepartment(updatedEmployee.getDepartment());
        employee.setEmail(updatedEmployee.getFirstname());
        employee.setLastname(updatedEmployee.getLastname());
        employee.setFirstname(updatedEmployee.getFirstname());
        empolyeeRepository.save(employee);


        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = empolyeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee does not exist with given id : "+employeeId));
        empolyeeRepository.deleteById(employeeId);

    }
}
