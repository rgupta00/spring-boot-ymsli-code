package com.empapp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.empapp.entities.Employee;
import com.empapp.service.EmployeeService;

@RestController
public class EmployeeRestController {

	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping(path="employee", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> allEmployees(){
		return employeeService.getAll();
	}
	
	@GetMapping(path="employee/{id}",produces=MediaType.APPLICATION_JSON_VALUE )
	public Employee getEmployeeById(@PathVariable(name="id")int id){
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping(path="employee",produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE )
	public Employee addEmployee(@RequestBody Employee employee){
		return employeeService.save(employee);
	}
	
	@PutMapping(path="employee/{id}",produces=MediaType.APPLICATION_JSON_VALUE, 
			consumes=MediaType.APPLICATION_JSON_VALUE )
	public Employee updateEmployee(@PathVariable(name="id") int id,   @RequestBody Employee emp){
		return  employeeService.update(id, emp);
		
	}
	
	
	@DeleteMapping(path="employee/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee deleteEmplloyee(@PathVariable(name="id") int id){
		return employeeService.delete(id);
	}
}
