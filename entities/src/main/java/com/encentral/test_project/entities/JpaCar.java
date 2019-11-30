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
@Table(name = "car")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JpaCar.findAll", query = "SELECT c FROM JpaCar c")})

public class JpaCar implements Serializable {

	
	@Id
    @Size(min = 15, max = 20)
    @Column(name = "license_id")
	@NotNull(message = "license can not be null!")
    private String licenseId;
	

    @Column(nullable = false)
    @Size(min = 2, max = 25)
    private int seat_count;

    @Column(nullable = false)
     private boolean convertible;

    @Column(nullable = false, name = "engine_type")
    private String engine_type;

    @Column(nullable = false)
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





	public JpaCar() {
		super();
	}
   
}
