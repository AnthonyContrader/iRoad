package it.contrader.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.VehicleDTO;
import it.contrader.model.User;
import it.contrader.service.VehicleService;


@RestController
@RequestMapping("/vehicle")
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController extends AbstractController<VehicleDTO>{
	@Autowired
	private VehicleService vehicleService;

	@PostMapping(value = "/getallbyuser")
	public VehicleDTO getAllByUser(@RequestBody User user ) {
		return vehicleService.findAllByUser(user);
	}
}


