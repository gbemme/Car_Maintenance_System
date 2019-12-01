package com.encentral.test_project.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Entity implementation class for Entity: JpaCar
 *
 */

@Entity
@Table(name = "Car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JpaCar.findAll", query = "SELECT c FROM JpaCar c")})

public class JpaCar implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Basic(optional = false)
    @Column(name = "license_id")
	@NotNull(message = "license can not be null!")
    private String licenseId;
	

    @Column(nullable = false,name = "seat_count")
    @Size(min = 2, max = 25)
    private Integer seat_count;

    @Column(nullable = false, name = "convertible")
     private boolean convertible;

    @Column(nullable = false, name = "engine_type")
    private String engine_type;

    @Column(nullable = false, name = "rating")
    private Integer rating;
    
    
    
    

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





	public JpaCar() {
		super();
	}
   
}
