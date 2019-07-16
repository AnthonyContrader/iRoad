package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.VehicleDTO;
import it.contrader.model.Vehicle;

public class ConverterVehicle {

	public static VehicleDTO toDTO(Vehicle vehicle) {
		VehicleDTO vehicleDTO = null;
		if (vehicle != null) {
			vehicleDTO = new VehicleDTO();
			vehicleDTO.setIdVehicle(vehicle.getIdVehicle());
			vehicleDTO.setNameVehicle(vehicle.getNameVehicle());
			vehicleDTO.setTypeVehicle(vehicle.getTypeVehicle());
			vehicleDTO.setSpeedVehicle(vehicle.getSpeedVehicle());		
			vehicleDTO.setWeightVehicle(vehicle.getWeightVehicle());
			vehicleDTO.setLongVehicle(vehicle.getLongVehicle());
			vehicleDTO.setLatVehicle(vehicle.getLatVehicle());
		}
		return vehicleDTO;
	}

	public static Vehicle toEntity(VehicleDTO vehicleDTO) {
		Vehicle vehicle = null;
		if (vehicleDTO != null) {
			vehicle = new Vehicle();
			vehicle.setIdVehicle(vehicleDTO.getIdVehicle());
			vehicle.setNameVehicle(vehicleDTO.getNameVehicle());
			vehicle.setTypeVehicle(vehicleDTO.getTypeVehicle());
			vehicle.setSpeedVehicle(vehicleDTO.getSpeedVehicle());
			vehicle.setWeightVehicle(vehicle.getWeightVehicle());
			vehicleDTO.setLongVehicle(vehicle.getLongVehicle());
			vehicleDTO.setLatVehicle(vehicle.getLatVehicle());
			
		}
		return vehicle;
	}

	public static List<VehicleDTO> toListDTO(List<Vehicle> list) {
		List<VehicleDTO> listVehicleDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Vehicle vehicle : list) {
				listVehicleDTO.add(ConverterVehicle.toDTO(vehicle));
			}
		}
		return listVehicleDTO;
	}

	public static List<Vehicle> toListEntity(List<VehicleDTO> listVehicleDTO) {
		List<Vehicle> list = new ArrayList<>();
		if (!listVehicleDTO.isEmpty()) {
			for (VehicleDTO vehicleDTO : listVehicleDTO) {
				list.add(ConverterVehicle.toEntity(vehicleDTO));
			}
		}
		return list;
	}
}
