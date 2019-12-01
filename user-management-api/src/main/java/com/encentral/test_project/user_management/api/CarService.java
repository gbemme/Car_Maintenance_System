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
	JpaCar selectCar(String licenseId) throws ResourceNotFound;

    JpaCar addCar(JpaCar carDO) ;

    void deselectCar(String licenseId) throws ResourceNotFound;
    
//    public List<JpaCar> search(String filter);
//    
//    public void update(JpaCar carDo);
    
//    JpaCar save(JpaCar carDO);

}
