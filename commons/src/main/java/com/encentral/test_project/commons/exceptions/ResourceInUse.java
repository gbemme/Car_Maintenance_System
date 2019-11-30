/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.encentral.test_project.commons.exceptions;

/**
 *
 * @author encentral_ubuntu
 */
public class ResourceInUse extends Exception {

    public ResourceInUse(String message) {
        super(message);
    }

    public static class Builder {

        String message;

        private Builder() {
        }

        public Builder message(String format, Object... args) {
            message = String.format(format, args);
            return this;
        }

        public ResourceInUse build() {
            return new com.encentral.test_project.commons.exceptions.ResourceInUse(message);
        }
    }

    public static ResourceInUse.Builder builder() {
        return new ResourceInUse.Builder();
    }

    private ResourceInUse() {
    }

}
