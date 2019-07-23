package it.contrader.converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.VehicleDTO;
import it.contrader.model.Vehicle;


@Component
public class VehicleConverter extends AbstractConverter<Vehicle,VehicleDTO> {
	@Autowired
	UserConverter converter;
	
	@Override
	public Vehicle toEntity(VehicleDTO vehicleDTO) {
		Vehicle vehicle = null;
		if (vehicleDTO != null) {
			vehicle = new Vehicle();
			vehicle.setIdVehicle(vehicleDTO.getIdVehicle());
			vehicle.setVehicletype(vehicleDTO.getVehicletype());
			vehicle.setNameVehicle(vehicleDTO.getNameVehicle());
			vehicle.setWeightVehicle(vehicleDTO.getWeightVehicle());
			vehicle.setSpeedVehicle(vehicleDTO.getSpeedVehicle());
			vehicle.setLongVehicle(vehicleDTO.getLongVehicle());
			vehicle.setLatVehicle(vehicleDTO.getLatVehicle());
			vehicle.setUser(converter.toEntity(vehicleDTO.getUserDTO()));
		}
		return vehicle;
	}

	@SuppressWarnings("null")
	@Override
	public VehicleDTO toDTO(Vehicle vehicle) {
		VehicleDTO vehicleDTO = null;
		if (vehicle != null) {
			vehicleDTO = new VehicleDTO(vehicle.getIdVehicle(),vehicle.getVehicletype(),vehicle.getNameVehicle(),vehicle.getSpeedVehicle(),vehicle.getWeightVehicle(),vehicle.getLongVehicle(),vehicle.getLatVehicle(),converter.toDTO(vehicle.getUser()));
		
		}
		return vehicleDTO;
	}
	
}
