package com.app.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.app.model.Employee;

@Component
public class EmployeeService {
	
	private static List<Employee> employees=new ArrayList<Employee>();
	
	static {
		
		Employee jeff=new Employee("1","Jeff");
		Employee mac=new Employee("2","Mac");
		employees.add(jeff);
		employees.add(mac);
	}
	
	public List<Employee> getAllEmployees(){
		for(Employee employee:employees) {
			System.out.println(employee.getName());
		}
	
		return employees;
	}
	
	public Employee getEmployee(String name) {
		for(Employee employee:employees) {
			if(employee.getName().equals(name))
				return employee;
		}
		return null;
	}
	public void removeEmployee(String name) {
		for(Employee e:employees) {
			if(e.getName().equals(name))
				employees.remove(e);
		}
	}
	private SecureRandom random = new SecureRandom();
	
	public Employee addEmployee(Employee newEmployee) {
		String randomId = new BigInteger(130, random).toString(32);
		newEmployee.setId(randomId);
		employees.add(newEmployee);
		return newEmployee;
		
	}
	public void updateEmployee(Employee updatedEmployee, String name) {
		for(Employee e:employees) {
			if(e.getName().equals(name)) {
				employees.remove(e);
				employees.add(updatedEmployee);
			}
		}
		
	}
}
