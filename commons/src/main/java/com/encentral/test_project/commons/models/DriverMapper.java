/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.commons.models;

import com.encentral.test_project.entities.JpaDriver;

/**
 *
 * @author James Akinniranye
 */
public class DriverMapper {

    public static DriverDTO jpaDriverToDriverDTO(JpaDriver jpaDriver) {
        DriverDTO dTO = new DriverDTO();
        dTO.setDateCreated(jpaDriver.getDateCreated());
        dTO.setDateModiied(jpaDriver.getDateModiied());
        dTO.setDriverId(jpaDriver.getDriverId());
        dTO.setUsername(jpaDriver.getUsername());
        dTO.setPassword(jpaDriver.getPassword());
        dTO.setOnlineStatus(jpaDriver.getOnlineStatus());
        return dTO;
    }

    public static JpaDriver driverDTotoJpaDriver(DriverDTO dTO) {
        JpaDriver jpaDriver = new JpaDriver();
        jpaDriver.setDateCreated(dTO.getDateCreated());
        jpaDriver.setDateModiied(dTO.getDateModiied());
        jpaDriver.setDriverId(dTO.getDriverId());
        jpaDriver.setUsername(dTO.getUsername());
        jpaDriver.setPassword(dTO.getPassword());
        jpaDriver.setOnlineStatus(dTO.getOnlineStatus());
        return jpaDriver;
    }
}
