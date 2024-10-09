package com.CRUDoperations.springbootCRUDapi.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.CRUDoperations.springbootCRUDapi.Dao.EmployeeDao;
import com.CRUDoperations.springbootCRUDapi.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Autowired
	private EmployeeDao dao;

	@Transactional
	@Override
	public List<Employee> get() {

		List<Employee> listAll = dao.get();
		return listAll;
	}

	@Transactional
	@Override
	public Employee get(int id) {
		Employee employee = dao.get(id);
		return employee;
	}

	@Transactional
	@Override
	public void save(Employee employee) {
		dao.save(employee);
		
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Transactional
	@Override
	public void update(Employee employee) {
		dao.update(employee);

	}

}
