package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.StreetRepository;
import it.contrader.dto.StreetDTO;
import it.contrader.model.Street;
import it.contrader.model.Street.Streettype;

@Service
public class StreetService extends AbstractService<Street,StreetDTO> {
	
	public StreetDTO findByStreetnameAndStreettype(String streetname, Streettype streettype) {
		return converter.toDTO(((StreetRepository)repository).findByStreetnameAndStreettype(streetname, streettype));
	}

}
