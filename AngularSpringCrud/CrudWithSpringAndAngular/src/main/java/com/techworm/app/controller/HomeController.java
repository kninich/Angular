package com.techworm.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techworm.app.model.Employee;
import com.techworm.app.serviceimpl.EmployeeImpl;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
@RequestMapping(value = "/employee")
public class HomeController {
	@Autowired
	private EmployeeImpl empService;
	@RequestMapping(value = "/saveEmp")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		System.out.println("Save Method ");
		empService.saveEmployee(employee);
		return employee;
		
	}
	@PutMapping(value = "/updateEmp")
	@CrossOrigin("*")
	public Employee updateEmployee(@RequestBody Employee employee)
	{
		System.out.println("Update Method");
		empService.updateEmployee(employee);
		return employee;
	}
	
	@DeleteMapping(value = "/deleteEmp/{id}")
	@CrossOrigin("*")
	public void deleteEmployee(@PathVariable ("id") Integer id)
	{
		System.out.println("Delete Method");
		empService.deleteEmployee(id);
		
	}
	@RequestMapping(value = "/getAllEmp")
	public List<Employee> getAllEmployee()
	{
		System.out.println("Get all Method");
		return empService.getAllEmployee();	
	}

}
