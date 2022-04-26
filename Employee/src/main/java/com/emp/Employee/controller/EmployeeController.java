package com.emp.Employee.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emp.Employee.entity.Employee;
import com.emp.Employee.service.EmploeeService;

@Controller
public class EmployeeController {
	private EmploeeService employeeService;

	public EmployeeController(EmploeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	/*
	 * @RequestMapping(value="/employees",method = RequestMethod.GET) public String
	 * viewLogin(Map<String, Object> model) { Employee emp = new Employee();
	 * model.put("create_employee",emp); return "create_employee"; }
	 */
	
	@GetMapping("/employees")
	public String listEmployees(Model model) {
		model.addAttribute("employee",employeeService.getAllEmployees());
		return "employee";
		
	}
	@GetMapping("/employees/new")
    public String createEmployeeForm(Model model) {
		Employee employee =new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
    	
    }
	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return"redirect:/employees";
	}
	@GetMapping("/employees/edit/{id}")
	public String editEmployeeForm(@PathVariable Long id,Model model) {
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		return "edit_employee";
	}
	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee")
			Employee employee,Model model){
		Employee exsitngEmployee = employeeService.getEmployeeById(id);
		exsitngEmployee.setId(id);
		exsitngEmployee.setUserName(employee.getUserName());
		exsitngEmployee.setEmail(employee.getEmail());
		
		employeeService.updateEmployee(exsitngEmployee);
		return "redirect:/employees";
	}
	@GetMapping("/employees/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";
	}
}
