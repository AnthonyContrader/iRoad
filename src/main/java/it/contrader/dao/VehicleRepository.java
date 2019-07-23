package it.contrader.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.User;
import it.contrader.model.Vehicle;

@Repository
@Transactional
public interface VehicleRepository extends CrudRepository<Vehicle, Long>{
	public Vehicle findAllByUser (User user);
}
