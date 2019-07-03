package it.contrader.service;

import it.contrader.converter.VehicleConverter;
import it.contrader.dao.VehicleDAO;
import it.contrader.dto.VehicleDTO;
import it.contrader.model.Vehicle;

public class VehicleService extends AbstractService<Vehicle, VehicleDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public VehicleService(){
		this.dao = new VehicleDAO();
		this.converter = new VehicleConverter();
	}
	

}
