package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;

import it.contrader.model.Sensor;

import java.util.List;

public interface SensorRepository extends CrudRepository<Sensor, Integer> {

	public Sensor findSensorBySensorPositionAndSensorType(String sensorPosition,String sensorType);
	public List<Sensor> findAllBySensorType(String sensorType);
}
