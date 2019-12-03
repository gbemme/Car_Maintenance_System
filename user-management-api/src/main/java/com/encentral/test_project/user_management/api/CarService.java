/**
 * 
 */
package com.encentral.test_project.user_management.api;

import java.util.List;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;

import com.encentral.test_project.entities.JpaCar;


/**
 * @author Nimot Imran
 *
 */
public interface CarService  {
	JpaCar selectCar(String licenseId,String driverId) throws ResourceNotFound;

    JpaCar addCar(JpaCar carDO) ;

    void deselectCar(String licenseId,String driverId) throws ResourceNotFound;
    


}
