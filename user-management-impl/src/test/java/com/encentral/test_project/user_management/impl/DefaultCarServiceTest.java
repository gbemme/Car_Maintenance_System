package com.encentral.test_project.user_management.impl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.user_management.api.CarService;
import com.google.inject.Inject;

import play.db.jpa.JPAApi;

public class DefaultCarServiceTest {
	
	

	@Inject
	CarService carService;
	
	DefaultCarService defaultCarService;
	JpaCar jpaCar;
	
	
	@Before
	public void setUp() throws Exception {
		
		defaultCarService = new DefaultCarService();
		
		jpaCar = new JpaCar();
		
		jpaCar.setLicenseId("23");
	}

	@After
	public void tearDown() throws Exception {
	}
	

	@Test
	public void defaultCarServiceTest() {
		
		
		assertNotNull(defaultCarService);
		assertNotNull(jpaCar);
		
	}
	


}
