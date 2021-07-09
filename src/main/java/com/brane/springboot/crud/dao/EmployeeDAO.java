package com.brane.springboot.crud.dao;

import java.util.List;

import com.brane.springboot.crud.entity.Employee;

//we created interface form employee DAO (Data Access Object) to access data from the database
//this we will use to do all CRUD methods on database
public interface EmployeeDAO {

			public List<Employee> findAll();

			public Employee findById(int theId);
			
			public void save(Employee theEmployee);

			public void deleteById(int theId);
}
