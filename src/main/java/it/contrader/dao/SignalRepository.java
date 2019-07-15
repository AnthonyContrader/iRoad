package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Signal;

import java.util.List;


public interface SignalRepository extends CrudRepository<Signal, Integer> {
	public Signal findSignalbySignlType(String signalType);
	public Signal getBySignalType(String signalType);
	public List<Signal> findAllBySignalType(String signalType);
}
