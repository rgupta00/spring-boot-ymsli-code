package com.empapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;

import com.empapp.entity.Employee;
import com.empapp.repo.EmpRepo;

@RestController
@RequestMapping(path = "api")
public class EmployeeRestController {

	private EmpRepo empRepo;

	@Autowired
	public EmployeeRestController(EmpRepo empRepo) {
		this.empRepo = empRepo;
	}
	@GetMapping(path = "employee",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmps(){
		return empRepo.findAll();
	}

}
