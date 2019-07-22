package it.contrader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.SignaleDTO;
import it.contrader.service.SignaleService;

@RestController
@RequestMapping("/signale")
@CrossOrigin(origins = "http://localhost:4200")
public class SignaleController extends AbstractController<SignaleDTO>{
	
}

