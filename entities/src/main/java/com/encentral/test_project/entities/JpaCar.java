package com.encentral.test_project.entities;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: JpaCar
 *
 */

@Entity
@Table(name = "Car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JpaCar.findAll", query = "SELECT j FROM JpaCar j")})
	
public class JpaCar implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Basic(optional = false)
    @Column(name = "license_id")
	@NotNull
    private String licenseId;
	
	@NotNull(message = "seatCount can not be null!")
    @Column(nullable = false,name = "seat_count")
    
    private Integer seatCount;
	
	@NotNull(message = "Convertible can not be null!")
    @Column(name = "convertible")
     private Boolean convertible;
	
	@NotNull(message = "Engine type can not be null!")
    @Column(nullable = false, name = "engine_type")
    private String engineType;

    @Column(nullable = false, name = "rating")
    private Integer rating;
    
    
    @Column(name = "selected") 
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





	public JpaCar() {
		super();
	}
   
}
