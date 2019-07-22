package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.StreetRepository;
import it.contrader.dto.StreetDTO;
import it.contrader.model.Sensor;
import it.contrader.model.Street;
import it.contrader.model.Street.Streettype;

@Service
public class StreetService extends AbstractService<Street,StreetDTO> {
	
	public StreetDTO findByStreetnameAndStreettype(String streetname, Streettype streettype) {
		return converter.toDTO(((StreetRepository)repository).findByStreetnameAndStreettype(streetname, streettype));
	}
 
	public List<StreetDTO> findAllBySensor(Sensor sensor) {
		return converter.toDTOList(((StreetRepository) repository).findAllBySensor(sensor));
	}
}
