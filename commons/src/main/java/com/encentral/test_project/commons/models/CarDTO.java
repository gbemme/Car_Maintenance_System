/**
 * 
 */
package com.encentral.test_project.commons.models;

/**
 * @author Nimot Imran
 *
 */


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class CarDTO {
	
	
	private String licenseId;

    @NotNull(message = "license can not be null!")
    @Size(min = 15)
    
    private int  seat_count;
    @Size(min = 2)
    
    private boolean convertible;

    
    private String engine_type;
    
    
    private int rating;


	public String getLicenseId() {
		return licenseId;
	}


	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}


	public int getSeat_count() {
		return seat_count;
	}


	public void setSeat_count(int seat_count) {
		this.seat_count = seat_count;
	}


	public boolean isConvertible() {
		return convertible;
	}


	public void setConvertible(boolean convertible) {
		this.convertible = convertible;
	}


	public String getEngine_type() {
		return engine_type;
	}


	public void setEngine_type(String engine_type) {
		this.engine_type = engine_type;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}
    

}
