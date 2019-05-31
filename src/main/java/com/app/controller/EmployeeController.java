package com.app.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.model.Employee;
import com.app.service.EmployeeService;


@RestController
public class EmployeeController {
 
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "Welcome!";
	}
	
	@GetMapping("/employee/{name}")
	public Employee retrieveEmployeeDetails(@PathVariable String name) {
		return employeeService.getEmployee(name);
	}
	
	@GetMapping("/employee/all")
	public List<Employee> retrieveEmployeeDetails() {
		return employeeService.getAllEmployees();
	}
	
	@DeleteMapping("/employee/{name}")
	public void deleteEmployee(@PathVariable String name) {
		employeeService.removeEmployee(name);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<Object> createEmployee(@RequestBody Employee newEmployee){
		newEmployee=employeeService.addEmployee(newEmployee);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(newEmployee.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/employee/{name}")
	public ResponseEntity<Object> updateEmployeeDetails(@RequestBody Employee updatedEmployee, @PathVariable String name){
		if(employeeService.getEmployee(name).equals(null))
			return ResponseEntity.notFound().build();
		else
		{
			employeeService.updateEmployee(updatedEmployee, name);
			return ResponseEntity.noContent().build();
		}
	}
}
