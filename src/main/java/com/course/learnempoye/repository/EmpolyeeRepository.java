package com.course.learnempoye.repository;

import com.course.learnempoye.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpolyeeRepository extends JpaRepository<Employee,Long> {
}
