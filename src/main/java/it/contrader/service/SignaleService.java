package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.SignaleRepository;
import it.contrader.dto.SignaleDTO;
import it.contrader.model.Signale;
import it.contrader.model.Signale.Signaletype;

@Service
public class SignaleService extends AbstractService<Signale,SignaleDTO> {
	
	public SignaleDTO findByNameSignaleAndSignaletype(String nameSignale, Signaletype signaletype) {
		return converter.toDTO(((SignaleRepository)repository).findBySignalenameAndSignaletype(nameSignale,signaletype));
	}

}