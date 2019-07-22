package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.VehicleRepository;
import it.contrader.dto.VehicleDTO;
import it.contrader.model.Vehicle;

@Service
public class VehicleService extends AbstractService<Vehicle,VehicleDTO> {
	
	public VehicleDTO findByNameVehicleAndVehicletype(String nameVehicle, String vehicletype) {
		return converter.toDTO(((VehicleRepository)repository).findByNameVehicleAndVehicletype(nameVehicle,vehicletype));
	}

}
