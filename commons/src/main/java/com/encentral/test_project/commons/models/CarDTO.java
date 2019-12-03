/**
 * 
 */
package com.encentral.test_project.commons.models;
/**
 * @author Nimot Imran
 *
 */


import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
	
	@NotNull(message = "license can not be null!")
	private String licenseId;

    
    @NotNull(message = "seat count can not be null!")
    
    private Integer  seatCount;
    
    @NotNull(message = "convertible can not be null!")

    private Boolean convertible;
    
    @NotNull(message = "egine type can not be null!") 
    private String engineType;
    
    
    @NotNull(message = "rating can not be null!")

    private Integer rating;
    
   
    
    private Boolean selected;

	public String getLicenseId() {
		return licenseId;
	}


	public void setLicenseId(String licenseId) {
		this.licenseId = licenseId;
	}


	public Integer getSeatCount() {
		return seatCount;
	}


	public void setSeatCount(Integer seatCount) {
		this.seatCount = seatCount;
	}


	public Boolean isConvertible() {
		return convertible;
	}


	public void setConvertible(Boolean convertible) {
		this.convertible = convertible;
	}


	public String getEngineType() {
		return engineType;
	}


	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}


	public Integer getRating() {
		return rating;
	}


	public void setRating(Integer rating) {
		this.rating = rating;
	}


	public Boolean getSelected() {
		return selected;
	}


	public void setSelected(Boolean selected) {
		this.selected = selected;
	}
    

}
