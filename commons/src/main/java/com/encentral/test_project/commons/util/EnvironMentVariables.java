/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.commons.util;

import java.util.Optional;

/**
 *
 * @author Akinniranye James Ayodele
 */
public class EnvironMentVariables {

    public static final String API_SERVER_URL = Optional.ofNullable(System.getenv("API_SERVER_URL")).orElse("http://apps.showcase.com.ng/api-server");


}
