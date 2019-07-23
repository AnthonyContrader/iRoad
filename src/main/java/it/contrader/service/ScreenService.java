package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.ScreenRepository;
import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

@Service
public class ScreenService extends AbstractService<Screen,ScreenDTO> {
	
	public ScreenDTO findByOutput(String output) {
		return converter.toDTO(((ScreenRepository)repository).findByOutput(output));
	}

}

