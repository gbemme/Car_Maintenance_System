/**
 * 
 */
package controllers;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.commons.models.DriverDTO;
import com.encentral.test_project.entities.JpaDriver;
import com.encentral.test_project.user_management.api.DriverService;
import com.google.inject.Inject;

/**
 * @author Nimot Imran
 *
 */
public class MaintenanceTest {
	//DriverController driverController = new CarController();
	JpaDriver jpaDriver = new JpaDriver(); 
	DriverDTO driverDTO = new DriverDTO();
	DriverService driverService;
	
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		//
//		driverDTO.setDriverId("56");
//		driverDTO.setDriverId("online");
//		driverDTO.setPassword("112345");
//		driverDTO.setUsername("taxiDriver");
//		driverDTO.setDateCreated(Date.UTC(2019, 06, 26,14,06,4));
		//driverDTO.
		
	}
	

	 
	
	@After
	 public void tearDown() throws Exception {
	}

	@Test
	public void testMyControllerObject() throws ResourceNotFound {
		
		
		
		//assertNotNull(driverController);
		assertNotNull(driverDTO);
		
	}
	
	
}
