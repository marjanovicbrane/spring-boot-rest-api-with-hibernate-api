package com.brane.springboot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brane.springboot.crud.entity.Employee;
import com.brane.springboot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	///private field employeeService, so we can do constructor dependency injection 
	//to delegate calls from CONTROLLER LAYER TO THE SERVICE LAYER
	private EmployeeService employeeService;
	
	//constructor injection
	@Autowired
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	

	//****************************************************************************************************************
	//WE WILL USING POSTMAN REST CLIENT TO SHOW ALL RESULTS FROM THE HTTP REQUEST METHODS.
	//IMPORTANT THING IS THAT JACKSON IS AUTOMATICALLY EMBEDDED IN SPRING BOOT, SO WHEN WE RUN OUR APP
	//AND THIS ENDPOINT /api/employees (GET) WI WILL HAVE RESPONSE OBJECTS FROM THE DATABASE IN .JSON FORMAT.
	//THAT DATA WE CAN SHOW IN BROWSER OR SOME OTHER REST CLIENT LIKE POSTMAN.
	//WHEN WE GET JAVA OBJECTS FROM THE DATABASE, SPRING BOOT HERE CALLS JACKSON TO CONVERT JAVA POJO IN .JSON FORMAT.
	//WHEN WE CONVERT JAVA POJO TO JSON--->JACKSON CALLS GETTER METHODS
	//WHEN WE CONVERT JSON TO JAVA POJO--->JACKSON CALLS SETTER METHODS
	//*****************************************************************************************************************
	
	
	//add mapping for GET /employees
	@GetMapping("/employees")
	public List<Employee> findAll(){
		
		//delegate calls from the CONTROLLER LAYER to the SERVICE LAYER
		return employeeService.findAll();
		
	}
		
}
