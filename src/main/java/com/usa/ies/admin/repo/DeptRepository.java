package com.usa.ies.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.usa.ies.admin.entities.Department;
import com.usa.ies.admin.entities.Employee;

public interface DeptRepository extends JpaRepository<Department, Integer>{
	
	

}
