/**
 * 
 */
package com.encentral.test_project.user_management.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import com.encentral.test_project.commons.exceptions.CarAlreadyInUseException;
import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.commons.models.CarDTO;
import com.encentral.test_project.commons.models.CarMapper;
import com.encentral.test_project.commons.models.DriverDTO;
import com.encentral.test_project.commons.models.DriverMapper;
import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.entities.JpaDriver;
import com.encentral.test_project.user_management.api.CarService;

import play.db.jpa.JPAApi;

/**
 * @author Nimot Imran
 *
 */
public class DefaultCarService implements CarService {
	
	private Map<DriverDTO, CarDTO> mapDriverToCar = new HashMap<>();
	
	 @Inject
	    JPAApi jPAApi;
	 
	 @Inject
	 JpaDriver jpaDriver;
	 
	 
	 
//   public void mapDriverToCar(String driverId, String carLicenceId) {
// 	
// 	try {
//			mapDriverToCar.put(DriverMapper.jpaDriverToDriverDTO(driverId), CarMapper.jpaCarToCarDTO(carService.selectCar(carLicenceId)));
//		} catch (ResourceNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
// }
// 
// public Map<DriverDTO, CarDTO> getDriverToCarMap(){
// 	
// 	return mapDriverToCar;
// 	
// }
	 @Inject
	 JpaCar car;

	    @Override
	    public JpaCar selectCar(String licenseId) {
	    	try {
	         car = jPAApi.em().find(JpaCar.class, licenseId);
	        
	      //mapDriverToCar(driverId, licenseId);
	        if (car == null) {
	        	
	            throw new ResourceNotFound(String.format("Car with license_number %s not found", licenseId));
	            
	        	}
	        
	        if(jpaDriver.getOnlineStatus()!="ONELINE") {
	        	
	        	
	        	throw new CarAlreadyInUseException(String.format("Car with license_number %s has been used", licenseId));
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
	    public void deselectCar(String licenseId) throws ResourceNotFound {
	        jPAApi.em().detach(selectCar(licenseId));
	    }

	

}
