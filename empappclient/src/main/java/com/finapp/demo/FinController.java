package com.finapp.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FinController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping(path = "fin/{id}")
	public String hello(@PathVariable(name = "id")int id) {
		
		Employee emp = restTemplate
				.getForObject("http://localhost:8080/empapp/employee/"+id, Employee.class);
		return emp.toString();
	}

	// it is a client of empapp that give all employeess
	@GetMapping(path = "fin2")
	public String hello2() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);//i want to get json from u

		HttpEntity<Object> httpstatus = new HttpEntity<>(headers);

		//restTemplate.exchange(url, method, requestEntity, responseType)
		
		ResponseEntity<List> responseEntity = 
				restTemplate.exchange("http://localhost:8080/empapp/employee",
						HttpMethod.GET,httpstatus, List.class);
	
		//this method will give u all emp
		List body = responseEntity.getBody();
		//typecasting?
		for(Object emp:body) {
			System.out.println(emp);
		}
		
		System.out.println("----------------------");
		//System.out.println(responseEntity.getBody());
		System.out.println(responseEntity.getStatusCode());
		
		
		return "example of exchange method";
	}
	
	//?
	@GetMapping(path = "fin3")
	public  String foo3() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);//i want to get json from u
		

		HttpEntity<Object> httpstatus = new HttpEntity<>(headers);
		
		 Employee emp=new Employee("ravi", 32);
		

		 ResponseEntity<Employee> responseEntity =
				 restTemplate.exchange("http://localhost:8080/empapp/employee",
	                HttpMethod.POST,
	                httpstatus,
	                Employee.class, emp);

	        HttpStatus statusCode = responseEntity.getStatusCode();
	        System.out.println("status code - " + statusCode);
	        Employee employee = responseEntity.getBody();
	        System.out.println("response body - " + employee);
	        HttpHeaders responseHeaders = responseEntity.getHeaders();
	        System.out.println("response Headers - " + responseHeaders);
	        
	        return "hello post";
	}
	
	@GetMapping(path = "fin4")
	public  String foo4() {
		 Employee emp=new Employee("indu", 32);
		ResponseEntity<Employee> responseEntityEmployee = restTemplate.postForEntity
				 ("http://localhost:8080/empapp/employee", emp, Employee.class);
		 System.out.println(responseEntityEmployee.getBody());
		 System.out.println(responseEntityEmployee.getStatusCode());
	        return "hello post";
	}
	
	
	@GetMapping(path = "fin5")
	public  String foo5() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);//i want to get json from u
		

		HttpEntity<Object> httpstatus = new HttpEntity<>(headers);
		
		
		ParameterizedTypeReference<List<Employee>>typeRef = 
				new ParameterizedTypeReference<List<Employee>>() {
		     };
		
		ResponseEntity<List<Employee>> responseEntity = 
				restTemplate.exchange("http://localhost:8080/empapp/employee",
						HttpMethod.GET, new HttpEntity<>(httpstatus), typeRef);
		
		List<Employee> emps = responseEntity.getBody();
		
//		ResponseEntity<List> respEntity =
//				restTemplate.getForEntity("http://localhost:8080/empapp/employee", List.class);
//		
//		System.out.println(respEntity.getStatusCode());
//		List<Employee> emps=respEntity.getBody();
		emps.forEach(e-> System.out.println(e));
		System.out.println("------------------");
		return "foo5";
	}
}








