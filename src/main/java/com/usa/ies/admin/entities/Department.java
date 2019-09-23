package com.usa.ies.admin.entities;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="department")
public class Department {
	@Id
	@GeneratedValue
	private int deptno;
	@Column(name="dname")
	private String name;
	private String loc;
	@JsonIgnore
	
	@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
	@OneToMany(mappedBy="dept",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Employee> emp;
	
	
	public List<Employee> getEmp() {
		return emp;
	}
	public void setEmp(List<Employee> emp) {
		this.emp = emp;
	}
	public String getName() {
		return name;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	

}
