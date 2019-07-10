package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;


import it.contrader.model.Street;

import java.util.List;

public interface StreetRepository extends CrudRepository<Street, Integer> {
	

	public Street findStreetByStreetNameAndStreetType(String streetName,String streetType);
	public List<Street> findAllByStreetType(String streetType);
	
	
}

