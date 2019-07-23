package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.VehicleRepository;
import it.contrader.dto.VehicleDTO;
import it.contrader.model.User;
import it.contrader.model.Vehicle;

@Service
public class VehicleService extends AbstractService<Vehicle,VehicleDTO> {
	
	public VehicleDTO findAllByUser(User user) {
		return converter.toDTO(((VehicleRepository)repository).findAllByUser(user));
	}

}
