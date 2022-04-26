package com.emp.Employee.service;

import java.util.List;

import com.emp.Employee.entity.Employee;

public interface EmploeeService {
	List<Employee> getAllEmployees();
	
	Employee saveEmployee(Employee employee);
    Employee getEmployeeById(Long id);
    Employee updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
}
