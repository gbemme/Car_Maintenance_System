/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.user_management.impl;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.commons.models.DriverDTO;
import com.encentral.test_project.entities.JpaDriver;
import com.encentral.test_project.user_management.api.DriverService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import play.db.jpa.JPAApi;

/**
 *
 * @author James Akinniranye
 */
public class DefaultDriverService implements DriverService {

    @Inject
    JPAApi jPAApi;
    
    @Inject
    DriverDTO driverDTO;
    
    @Inject
    JpaDriver jpaDriver;
    
    

    @Override
    public JpaDriver find(String driverId) throws ResourceNotFound {
        JpaDriver driver = jPAApi.em().find(JpaDriver.class, driverId);
        if (driver == null) {
            throw new ResourceNotFound(String.format("Driver with id %s not found", driverId));
        }
        return driver;
    }

    @Override
    public JpaDriver create(JpaDriver driverDO) {
        driverDO.setDriverId(java.util.UUID.randomUUID().toString());
        driverDO.setDateCreated(new Date());
        jPAApi.em().persist(driverDO);
        return driverDO;
    }

    @Override
    public void delete(String driverId) throws ResourceNotFound {
        jPAApi.em().detach(find(driverId));
    }
    
    
    @Override
    public List<JpaDriver> search(String parameter) throws ResourceNotFound{
    	List<JpaDriver> newJpaDriver = new ArrayList<JpaDriver>();
    	
    	if(jPAApi.em().contains(parameter)) {
    		
    		return newJpaDriver;
    	
    	}
    	else {
    		return null;
    	}
    }

}
