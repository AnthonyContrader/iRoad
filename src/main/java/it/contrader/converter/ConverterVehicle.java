package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.VehicleDTO;
import it.contrader.model.Vehicle;

public class ConverterVehicle {

	public static VehicleDTO toDTO(Vehicle vehicle) {
		VehicleDTO vehicleTDO = null;
		if (vehicle != null) {
			vehicleTDO = new VehicleDTO();
			vehicleTDO.setIdVehicle(vehicle.getIdVehicle());
			vehicleTDO.setNameVehicle(vehicle.getNameVehicle());
			vehicleTDO.setTypeVehicle(vehicle.getTypeVehicle());
			vehicleTDO.setSpeedVehicle(vehicle.getSpeedVehicle());
			vehicleTDO.setWeightVehicle(vehicle.getWeightVehicle());
			vehicleTDO.setLongVehicle(vehicle.getLongVehicle());
			vehicleTDO.setLatVehicle(vehicle.getLatVehicle());
		}
		return vehicleTDO;
	}

	public static Vehicle toEntity(VehicleDTO vehicleTDO) {
		Vehicle vehicle = null;
		if (vehicleTDO != null) {
			vehicle = new Vehicle();
			vehicle.setIdVehicle(vehicle.getIdVehicle());
			vehicle.setNameVehicle(vehicle.getNameVehicle());
			vehicle.setTypeVehicle(vehicle.getTypeVehicle());
			vehicle.setSpeedVehicle(vehicle.getSpeedVehicle());
			vehicle.setWeightVehicle(vehicle.getWeightVehicle());
			vehicle.setLongVehicle(vehicle.getLongVehicle());
			vehicle.setLatVehicle(vehicle.getLatVehicle());
		}
		return vehicle;
	}

	public static List<VehicleDTO> toListDTO(List<Vehicle> list) {
		List<VehicleDTO> listVehicleDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Vehicle vehicle: list) {
				listVehicleDTO.add(ConverterVehicle.toDTO(vehicle));
			}
		}
		return listVehicleDTO;
	}

	public static List<Vehicle> toListEntity(List<VehicleDTO> listVehicleDTO) {
		List<Vehicle> list = new ArrayList<>();
		if (!listVehicleDTO.isEmpty()) {
			for (VehicleDTO vehicleTDO : listVehicleDTO) {
				list.add(ConverterVehicle.toEntity(vehicleTDO));
			}
		}
		return list;
	}
}
