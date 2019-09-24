package com.usa.ies.admin.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usa.ies.admin.entities.Department;
import com.usa.ies.admin.entities.Employee;
import com.usa.ies.admin.repo.DeptRepository;
import com.usa.ies.admin.repo.EmployeeRepository;

public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DeptRepository deptRepository;
	
	
	@GetMapping("/getEmp/{id}")
	public Employee getEmployee(@PathVariable("id") int id) {
	System.out.println("I love you");
	return employeeRepository.findById(id).get();
	}
	@GetMapping("/count")
	public Long count() {
	return	employeeRepository.fetchCount();
	}
	
	@GetMapping("/emp/{dno}")
	public List<Employee> findBydeptno(@PathVariable("dno") int dno) {
	return	employeeRepository.findByDeptDeptno(dno);
	}
	
	
	@GetMapping("/msal")
	public List<Employee> maxSal() {
	return	employeeRepository.fetchMaxSal();
	}
	
	@GetMapping("/getDept")
	public List<Department> getDept() {
	return	deptRepository.findAll();
	}
	
	@GetMapping("/get")
	public Iterable<Employee> retrieve() {
		Iterable<Employee> emp=employeeRepository.findAll();
		return emp;
	}
	
	@PostMapping("/add")
	public @ResponseBody Employee insertEmpData(@RequestBody Employee emp) {
		
	Employee employee=	employeeRepository.save(emp);
	return employee;
		
	}
	@PutMapping("/update")
	public @ResponseBody Employee updateEmp(@RequestBody Employee emp) {
		Employee employee=employeeRepository.save(emp);
		return employee;
	}
	
	@DeleteMapping("/delete/{empno}")
	public String deleteEmp(@PathVariable("empno") int empno) {
		employeeRepository.deleteById(empno);
		return "Successfully deleted";
	}
	
	
	
}
