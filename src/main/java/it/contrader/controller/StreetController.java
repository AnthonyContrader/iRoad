package it.contrader.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.StreetDTO;
import it.contrader.model.Sensor;
import it.contrader.service.StreetService;


@RestController
@RequestMapping("/Street")

@CrossOrigin(origins = "http://localhost:4200")
public class StreetController extends AbstractController<StreetDTO>{
	
	

	@Autowired
	private StreetService streetService;

	@PostMapping(value = "/getallbysensor")
	public List<StreetDTO> getAllBySensor(@RequestBody Sensor sensor ) {
		return streetService.findAllBySensor(sensor);
	}
	
}