/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.commons.exceptions;

import java.util.List;
import java.util.Map;

/**
 *
 * @author poseidon
 */
public class MultipleResource extends Exception {

    public final List<Map<String, Object>> resources;

    public MultipleResource(String mesStri, List<Map<String, Object>> resources) {
        super(mesStri);
        this.resources = resources;
    }

}
