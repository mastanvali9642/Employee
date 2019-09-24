package com.usa.ies.admin;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.usa.ies.admin.repo.EmployeeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeApplicationTests {
	
	@Autowired
	EmployeeRepository employeeRepository;
	

	public void test_count() {
		
	long =	employeeRepository.fetchCount();
	assertEquals(count, 15);

		
	}
	
	
	
}
