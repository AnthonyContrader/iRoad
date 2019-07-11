package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Vehicle;

import java.util.List;

public interface VehicleRepository extends CrudRepository<Vehicle, Integer> {

	public Vehicle getByNameVehicleAndTypeVehicle(String nameVehicle, String typeVehicle);
	public Vehicle findVehicleByNameVehicleAndTypeVehicle(String nameVehilce, String typeVehicle);
	public List<Vehicle> findAllBytypeVehicle(String typrVehicle);
	
}
