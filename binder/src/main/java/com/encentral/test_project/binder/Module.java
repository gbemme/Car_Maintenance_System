/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.binder;

import com.encentral.test_project.commons.util.MyObjectMapper;
import com.encentral.test_project.user_management.api.CarService;
import com.encentral.test_project.user_management.api.DriverService;
import com.encentral.test_project.user_management.impl.DefaultCarService;
import com.encentral.test_project.user_management.impl.DefaultDriverService;
import com.google.inject.AbstractModule;


/**
 *
 * @author poseidon
 */
public class Module extends AbstractModule {

    @Override
    protected void configure() {
    	bind (CarService.class).to(DefaultCarService.class);
        bind(DriverService.class).to(DefaultDriverService.class);
        bind(MyObjectMapper.class).toInstance(new MyObjectMapper());

    }

}
