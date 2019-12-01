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

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
	
	
	private String licenseId;

    @NotNull(message = "license can not be null!")
   
    private Integer  seat_count;
    @NotNull(message = "seat count can not be null!")
    @Size(min = 2)
    
    private boolean convertible;
    @NotNull(message = "convertible can not be null!")

    
    private String engine_type;
    @NotNull(message = "egine type can not be null!")
    
    private Integer rating;
    @NotNull(message = "rating can not be null!")


	public String getLicenseId() {
		return licenseId;
	}


	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}


	public Integer getSeat_count() {
		return seat_count;
	}


	public void setSeat_count(Integer seat_count) {
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


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}
    

}
