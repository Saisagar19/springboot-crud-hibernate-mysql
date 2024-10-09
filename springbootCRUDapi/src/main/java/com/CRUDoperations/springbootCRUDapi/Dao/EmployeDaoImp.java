package com.CRUDoperations.springbootCRUDapi.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.CRUDoperations.springbootCRUDapi.model.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeDaoImp implements EmployeeDao {

	@Autowired
	private EntityManager entityManager;
	
	@Override
	public List<Employee> get() {
		Session session=entityManager.unwrap(Session.class);
		Query<Employee> query=session.createQuery("FROM Employee", Employee.class);
		List<Employee> list=query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee employee=session.get(Employee.class, id);
		return employee;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void save(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.save(employee);
		
	}

	@Override
	public void delete(int id) {
		Session session=entityManager.unwrap(Session.class);
		Employee employeeObj=session.get(Employee.class, id);
		session.remove(employeeObj);	
	}

	@SuppressWarnings("deprecation")
	@Override
	public void update(Employee employee) {
		Session session=entityManager.unwrap(Session.class);
		session.saveOrUpdate(employee);
		
	}

}
