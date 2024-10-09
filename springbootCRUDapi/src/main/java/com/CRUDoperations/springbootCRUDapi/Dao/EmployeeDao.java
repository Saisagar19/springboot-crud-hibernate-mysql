package com.CRUDoperations.springbootCRUDapi.Dao;

import java.util.List;

import com.CRUDoperations.springbootCRUDapi.model.Employee;

public interface EmployeeDao {
	
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
	
	void update(Employee employee);

}
