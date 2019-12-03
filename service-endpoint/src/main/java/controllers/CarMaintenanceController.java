/**
 * 
 */
package controllers;

import javax.inject.Inject;

import com.encentral.test_project.commons.exceptions.ResourceNotFound;
import com.encentral.test_project.commons.models.CarDTO;
import com.encentral.test_project.commons.models.CarMapper;
import com.encentral.test_project.commons.util.MyObjectMapper;
import com.encentral.test_project.entities.JpaCar;
import com.encentral.test_project.user_management.api.CarService;
import com.typesafe.config.Config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;

/**
 * @author Nimot Imran
 *
 */
@Api(value = "Car Maintenance System")
@Transactional
public class CarMaintenanceController  extends DriverController {
	
	
	private final Config config;
	
	
	  
	@Inject
	public CarMaintenanceController(Config config) {
		this.config = config;
	}
	
	
	
	@Inject
    FormFactory formFactory;

    @Inject
    CarService carService;
    
    @Inject
    MyObjectMapper objectMapper;

    
    
   

    @ApiOperation(value = "Select Car", notes = "", httpMethod = "GET")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done", response = CarDTO.class)
            }
    )
    
    public Result selectCar(String licenseId, String driverId) {
    	
        try {
        	
        	  
            return ok(Json.toJson(CarMapper.jpaCarToCarDTO(carService.selectCar(licenseId,driverId))));
        
        } catch (ResourceNotFound ex) {
        	
            return notFound(ex.getMessage());
        }
        
       
        
    }
    
    
	@ApiOperation(value = "Add Car", notes = "", httpMethod = "POST")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    @ApiImplicitParams(
            {
                @ApiImplicitParam(
                        name = "Application",
                        dataType = "com.encentral.test_project.commons.models.CarDTO",
                        required = true,
                        paramType = "body",
                        value = "Application"
                )
            }
    )
    public Result addCar() {
        Form<CarDTO> bindFromRequest = formFactory.form(CarDTO.class).bindFromRequest();
        if (bindFromRequest.hasErrors()) {
            return badRequest(bindFromRequest.errorsAsJson());

        }
        JpaCar addCar = carService.addCar(CarMapper.carDTotoJpaCar(bindFromRequest.get()));

        return ok(Json.toJson(CarMapper.jpaCarToCarDTO(addCar)));
    }


	@ApiOperation(value = "Deselect Car ", notes = "", httpMethod = "DELETE")
    @ApiResponses(
            value = {
                @ApiResponse(code = 200, message = "Done")
            }
    )
    public Result deselectCar(String licenseId, String driverId) {
        try {
            carService.deselectCar(licenseId, driverId);
            return noContent();
        } catch (ResourceNotFound ex) {
            return notFound(ex.getMessage());
        }
    }
}
