package com.encentral.test_project.commons.models;
import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.entities.JpaDriver;

public class CarMapper extends JpaDriver {
	
	
	
	public static CarDTO jpaCarToCarDTO(JpaCar jpaCar) {
        CarDTO dTO = new CarDTO();
        
        dTO.setLicenseId(jpaCar.getLicenseId());
        dTO.setSeat_count(jpaCar.getSeat_count());
        dTO.setConvertible(jpaCar.isConvertible());
        dTO.setEngine_type(jpaCar.getEngine_type());
        dTO.setRating(jpaCar.getRating());
        return dTO;
    }
	
	
	 public static JpaCar carDTotoJpaCar(CarDTO dTO) {
		 JpaCar jpaCar = new JpaCar();
		 jpaCar.setLicenseId(dTO.getLicenseId());
		 jpaCar.setSeat_count(dTO.getSeat_count());
		 jpaCar.setConvertible(dTO.isConvertible());
		 jpaCar.setEngine_type(dTO.getEngine_type());
		 jpaCar.setRating(dTO.getRating());
		 
	        return jpaCar;
	    }
	 
	 
	 

}
