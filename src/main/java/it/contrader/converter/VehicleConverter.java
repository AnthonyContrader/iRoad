package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.VehicleDTO;
import it.contrader.model.Vehicle;

/**
 * Implementando questa l'interfaccia converter la classe VehicleConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class VehicleConverter  implements Converter<Vehicle, VehicleDTO> {
	
	/**
	 * Crea un oggetto di tipo VehicleDTO e lo riempie con i campi del parametro user di tipo Vehicle.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */

	public VehicleDTO toDTO(Vehicle vehicle) {
		VehicleDTO vehicleDTO = new VehicleDTO(vehicle.getIdVehicle(), vehicle.getNameVehicle(), vehicle.getTypeVehicle(), vehicle.getSpeedVehicle(), vehicle.getWeightVehicle(), vehicle.getLatVehicle(), vehicle.getLongVehicle());
		return vehicleDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo UserDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Vehicle toEntity(VehicleDTO vehicleDTO) {
		Vehicle vehicle = new Vehicle(vehicleDTO.getIdVehicle(), vehicleDTO.getNameVehicle(), vehicleDTO.getTypeVehicle(), vehicleDTO.getSpeedVehicle(), vehicleDTO.getWeightVehicle(), vehicleDTO.getLatVehicle(), vehicleDTO.getLongVehicle());
		return vehicle;
	}
	
	/**
	 * Metodo per convertire le liste di Vehicle.
	 */
	@Override
	public List<VehicleDTO> toDTOList(List<Vehicle> vehicleList) {
		//Crea una lista vuota.
		List<VehicleDTO> vehicleDTOList = new ArrayList<VehicleDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Vehicle vehicle : vehicleList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			vehicleDTOList.add(toDTO(vehicle));
		}
		return vehicleDTOList;
	}

	
	
}
