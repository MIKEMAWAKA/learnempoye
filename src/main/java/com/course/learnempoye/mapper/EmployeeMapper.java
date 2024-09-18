package com.course.learnempoye.mapper;

import com.course.learnempoye.dto.EmployeeDto;
import com.course.learnempoye.entities.Employee;

public class EmployeeMapper {


   public  static EmployeeDto mapToEmployeeDto(Employee employee){
       return new EmployeeDto(
               employee.getId(),
               employee.getFirstname(),
               employee.getLastname(),
               employee.getLastname(),
               employee.getDepartment()

       );
   }


    public  static Employee mapToDtoEmployee(EmployeeDto employee){
        return new Employee(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getLastname(),
                employee.getDepartment()

        );
    }
}
