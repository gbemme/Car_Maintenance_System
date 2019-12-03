/**
 * 
 */
package com.encentral.test_project.user_management.impl;

import javax.inject.Inject;

import com.encentral.test_project.commons.exceptions.CarAlreadyInUseException;
import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.commons.models.DriverDTO;
import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.entities.JpaDriver;
import com.encentral.test_project.user_management.api.CarService;

import play.db.jpa.JPAApi;

/**
 * @author Nimot Imran
 *
 */


public class DefaultCarService implements CarService {
	
	
	 @Inject
	    JPAApi jPAApi;
	 
	 @Inject
	 JpaDriver jpaDriver;
	 
	 
	 @Inject
	 JpaCar car;
	 
	 @Inject
	 DriverDTO driverDTO;

	    @Override
	    public JpaCar selectCar(String licenseId, String driverId) {
	    	try {
	    		
	    			if(car.getSelected() == false){
	    				
	    				car = jPAApi.em().find(JpaCar.class, licenseId);
	    				
	    				car.setSelected(true);
	    				
	    				
	    			}
	    			
	    			else {
	    				
	    				throw new CarAlreadyInUseException(String.format("Car with license_number %s has been used", licenseId));
	    				
	    			}
	    			
	    			
	        
	     
			        if (car == null) {
			        	
			            throw new ResourceNotFound(String.format("Car with license_number %s not found", licenseId));
			            
			        	}
		        
	        
	    		
	        
	    	}
	    	catch(CarAlreadyInUseException ex){
	    		String.format(ex.getMessage());
	    		
	    	}
	    	catch(ResourceNotFound exp){
	    		String.format(exp.getMessage());
	    		
	    	}
	    	
	    	
	        return car;
	    }

	    @Override
	    public JpaCar addCar(JpaCar carDO) {
	        carDO.setLicenseId(java.util.UUID.randomUUID().toString());
	        
	        jPAApi.em().persist(carDO);
	        return carDO;
	    }

	    @Override
	    public void deselectCar(String licenseId, String driverId) throws ResourceNotFound {
	        jPAApi.em().detach(selectCar(licenseId,driverId));
	    }

	

}
