package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.VehicleDTO;
import it.contrader.model.Vehicle;

@Component
public class VehicleConverter extends AbstractConverter<Vehicle,VehicleDTO> {
	
	@Override
	public Vehicle toEntity(VehicleDTO vehicleDTO) {
		Vehicle vehicle = null;
		if (vehicleDTO != null) {
			vehicle = new Vehicle(vehicleDTO.getIdVehicle(),vehicleDTO.getVehicletype(),vehicleDTO.getNameVehicle(),vehicleDTO.getLatVehicle(),vehicleDTO.getLongVehicle(),vehicleDTO.getSpeedVehicle(),vehicleDTO.getWeightVehicle());			
		}
		return vehicle;
	}

	@SuppressWarnings("null")
	@Override
	public VehicleDTO toDTO(Vehicle vehicle) {
		VehicleDTO vehicleDTO = null;
		if (vehicle != null) {
			vehicleDTO = new VehicleDTO(vehicle.getIdVehicle(),vehicle.getVehicletype(),vehicle.getNameVehicle(),vehicle.getLatVehicle(),vehicle.getLongVehicle(),vehicle.getSpeedVehicle(),vehicle.getWeightVehicle());
		
		}
		return vehicleDTO;
	}
	
}
