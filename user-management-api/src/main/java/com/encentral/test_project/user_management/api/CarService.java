/**
 * 
 */
package com.encentral.test_project.user_management.api;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.entities.JpaDriver;

/**
 * @author Nimot Imran
 *
 */
public interface CarService  {
	JpaCar selectCar(String licenseId) throws ResourceNotFound;

    JpaCar addCar(JpaCar carDO) ;

    void deselectCar(String licenseId) throws ResourceNotFound;

}
