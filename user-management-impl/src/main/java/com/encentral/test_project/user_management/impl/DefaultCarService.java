/**
 * 
 */
package com.encentral.test_project.user_management.impl;

import java.util.Date;

import javax.inject.Inject;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
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

	    @Override
	    public JpaCar selectCar(String licenseId) throws ResourceNotFound {
	        JpaCar car = jPAApi.em().find(JpaCar.class, licenseId);
	        if (car == null) {
	            throw new ResourceNotFound(String.format("Car with license_number %s not found", licenseId));
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
	    public void deselectCar(String driverId) throws ResourceNotFound {
	        jPAApi.em().detach(selectCar(driverId));
	    }

	

}
