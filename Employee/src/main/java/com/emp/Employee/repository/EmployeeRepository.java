package com.emp.Employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.Employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
