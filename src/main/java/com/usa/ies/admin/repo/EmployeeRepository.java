package com.usa.ies.admin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.usa.ies.admin.entities.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	
	public Employee findByEmpno(int empno);
	
	
	
	@Query(value="select * from employee where sal=(select max(sal) from employee where sal<(select max(sal) from employee))",nativeQuery=true)
	public List<Employee> fetchMaxSal();
	
	
     @Query(value="select count(*) from employee",nativeQuery=true)
	 public long fetchCount();
     @Query(value="select * from employee where deptno=:dno",nativeQuery=true)
     public List<Employee> findByDeptDeptno(@Param("dno") int dno);
	 
}
