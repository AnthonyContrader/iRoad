package it.contrader.service;

import java.util.List;

import it.contrader.dao.SensorDAO;
import it.contrader.model.Sensor;


public class SensorService {
	
	private SensorDAO sensorDAO;
	
	public SensorService() {
		this.sensorDAO = new SensorDAO();
	}

	public List<Sensor> getAllSensor() {
		return this.sensorDAO.getAll();
	}
	
	public boolean insertSensor(Sensor sensor) {
		return this.sensorDAO.insert(sensor);
	}

	public Sensor readSensor(int sensorId) {
		return this.sensorDAO.read(sensorId);
	}
	
	public boolean updateSensor(Sensor sensorToUpdate) {
		return this.sensorDAO.update(sensorToUpdate);
	}
	
	public boolean deleteSensor(int sensorId) {
		return this.sensorDAO.delete(sensorId);
	}
	
	
}
