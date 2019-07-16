package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Sensor;

import java.util.List;

public interface SensorRepository extends CrudRepository<Sensor, Integer> {

	public Sensor findSensorByIdSensorAndSensorType(Integer idSensor,String sensorType);
	public List<Sensor> findAllByIdSensor(Integer idSensor);
	
	
}
