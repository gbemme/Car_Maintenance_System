package com.encentral.test_project.commons.models;
import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.entities.JpaDriver;

public class CarMapper  {
	
	
	
	public static CarDTO jpaCarToCarDTO(JpaCar jpaCar) {
        CarDTO dTO = new CarDTO();
        
        dTO.setLicenseId(jpaCar.getLicenseId());
        dTO.setSeatCount(jpaCar.getSeatCount());
        //dTO.setConvertible(jpaCar.isConvertible());
        dTO.setEngineType(jpaCar.getEngineType());
        dTO.setRating(jpaCar.getRating());
        return dTO;
    }
	
	
	 public static JpaCar carDTotoJpaCar(CarDTO dTO) {
		 JpaCar jpaCar = new JpaCar();
		 jpaCar.setLicenseId(dTO.getLicenseId());
		 jpaCar.setSeatCount(dTO.getSeatCount());
		 //jpaCar.setConvertible(dTO.isConvertible());
		 jpaCar.setEngineType(dTO.getEngineType());
		 jpaCar.setRating(dTO.getRating());
		 
	        return jpaCar;
	    }
	 
	 
	 
	 
	 
	 
	 

}
