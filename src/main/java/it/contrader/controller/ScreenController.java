package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import it.contrader.dto.LoginDTO;
import it.contrader.dto.ScreenDTO;
import it.contrader.service.ScreenService;

@RestController
@RequestMapping("/screen")
@CrossOrigin(origins = "http://localhost:4200")
public class ScreenController extends AbstractController<ScreenDTO>{
	
	@Autowired
	private ScreenService screenService;


}