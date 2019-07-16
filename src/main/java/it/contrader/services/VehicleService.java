package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterVehicle;
import it.contrader.dao.VehicleRepository;
import it.contrader.dto.VehicleDTO;
import it.contrader.model.Vehicle;

@Service
public class VehicleService {

	private final VehicleRepository vehicleRepository;

	@Autowired
	public VehicleService(VehicleRepository vehicleRepository) {
		this.vehicleRepository = vehicleRepository;
	}

	public List<VehicleDTO> getListaVehicleDTO() {
		return ConverterVehicle.toListDTO((List<Vehicle>) vehicleRepository.findAll());
	}

	public VehicleDTO getVehicleDTOById(Integer idVehicle) {
		return ConverterVehicle.toDTO(vehicleRepository.findById(idVehicle).get());
	}

	public VehicleDTO getByNamevehicleAndTypevehicle(String namevehicle, String typevehicle) {

		final Vehicle vehicle = vehicleRepository.findVehicleByNameVehicleAndTypeVehicle(namevehicle, typevehicle);

		return ConverterVehicle.toDTO(vehicle);
	}

	public boolean insertVehicle(VehicleDTO vehicleDTO) {
		return vehicleRepository.save(ConverterVehicle.toEntity(vehicleDTO)) != null;
	}

	public boolean updateVehicle(VehicleDTO vehicleDTO) {
		return vehicleRepository.save(ConverterVehicle.toEntity(vehicleDTO)) != null;
	}
	
	public void deleteVehicleById(Integer idVehicle) {
		vehicleRepository.deleteById(idVehicle);
	}
	
	public List<VehicleDTO> findVehicleDTOByNamevehicle(String namevehicle) {
		
		final List<Vehicle> list = vehicleRepository.findAllBytypeVehicle(namevehicle);
		final List<VehicleDTO> vehicleDTOs = new ArrayList<>();
		list.forEach(i -> vehicleDTOs.add(ConverterVehicle.toDTO(i)));
		return vehicleDTOs;
		
	
	}
}