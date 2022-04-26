package com.emp.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.emp.Employee.entity.Employee;
import com.emp.Employee.repository.EmployeeRepository;

@SpringBootApplication
@ComponentScan
public class EmployeeApplication implements CommandLineRunner{
    @Autowired
    private EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * // TODO Auto-generated method stub Employee emp = new
		 * Employee("abc","abc@gmail.com"); employeeRepository.save(emp); Employee emp1
		 * = new Employee("xyz","xyz@gmail.com"); employeeRepository.save(emp1);
		 */
	}

}
