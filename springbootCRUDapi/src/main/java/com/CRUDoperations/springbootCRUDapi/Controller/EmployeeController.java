package com.CRUDoperations.springbootCRUDapi.Controller;

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

import com.CRUDoperations.springbootCRUDapi.Service.EmployeeService;
import com.CRUDoperations.springbootCRUDapi.model.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> get() {

		List<Employee> listAll = employeeService.get();
		return listAll;
	}
	
	@GetMapping("/employees/{Eid}")
	public Employee get(@PathVariable("Eid") int id) {
		Employee employee=employeeService.get(id);
		if(employee==null)
		{
			throw new RuntimeException("Employee with id: "+id+" is not found");
		}
		return employee;
	}
	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee) {
		employeeService.save(employee);
		return employee;
	}
	
	@DeleteMapping("/delete/{Eid}")
	public String delete(@PathVariable("Eid") int id) {
		employeeService.delete(id);
		return "Employee has been deleted with id:"+id;
	}
	
	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee)
	{
		employeeService.update(employee);
		return employee;
		
	}
	
}
