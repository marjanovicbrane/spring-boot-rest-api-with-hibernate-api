package com.brane.springboot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.brane.springboot.crud.entity.Employee;

//THIS IS DAO LAYER
@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {
	
		//private field entityManager, so we can do constructor dependency injection
		private EntityManager entityManager;
		
		//constructor injection
		@Autowired
		public EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
			entityManager = theEntityManager;
		}
		
		
		@Override
		public List<Employee> findAll() {
			
			//GER CURRENT HIBERNATE SESSION
			//we are using method unwrap() to get current hibernate session
			Session currentSession=entityManager.unwrap(Session.class);
			
			//create a query and sort by last name
			//WE ARE USING HERE HIBERNATE API and HQL
			Query<Employee> query=currentSession.createQuery("from Employee",Employee.class);
			
			// execute query and get result list
			List<Employee> employees=query.getResultList();
			
			// return the results	
			return employees;
		}


		@Override
		public Employee findById(int theId) {
			
			//GER CURRENT HIBERNATE SESSION
			Session currentSession=entityManager.unwrap(Session.class);
			
			// now retrieve/read object from database using the primary key
			Employee employee=currentSession.get(Employee.class, theId);
			
			return employee;
		}
		

		@Override
		public void save(Employee theEmployee) {
			
			// get current hibernate session
			Session currentSession = entityManager.unwrap(Session.class);
					
			//save or upate the employee
			//if we have id then will execute update, otherwise will execute save
			currentSession.saveOrUpdate(theEmployee);
			
		}


		@Override
		public void deleteById(int theId) {
			
			Session currentSession = entityManager.unwrap(Session.class);
			
			// delete object with primary key
			//WE ARE ALSO USING HERE HIBERNATE API with HQL
			//first we need to define parameter employeeId 
			Query theQuery=currentSession.createQuery("delete from Employee where id=:employeeId");

			//and then we need to set the parameter to primary key theId
			theQuery.setParameter("employeeId", theId);//treba vidjeti da lije ovo parametra iz htmla

			//execute query
			theQuery.executeUpdate();
			
		}


	}
