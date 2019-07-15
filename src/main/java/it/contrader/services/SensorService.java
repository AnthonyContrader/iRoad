package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterSensor;
import it.contrader.dao.SensorRepository;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

@Service
public class SensorService {

	private final SensorRepository sensorRepository;

	@Autowired
	public SensorService(SensorRepository sensorRepository) {
		this.sensorRepository = sensorRepository;
	}

	public List<SensorDTO> getListaSensorDTO() {
		return ConverterSensor.toListDTO((List<Sensor>) sensorRepository.findAll());
	}

	public SensorDTO getSensorDTOById(Integer idSensor) {
		return ConverterSensor.toDTO(sensorRepository.findById(idSensor).get());
	}

	public SensorDTO getBySensorPositionAndSensorType(String sensorPosition, String sensorType) {

		final Sensor sensor = sensorRepository.findSensorBySensorPositionAndSensorType(sensorPosition, sensorType);

		return ConverterSensor.toDTO(sensor);
	}

	public boolean insertSensor(SensorDTO sensorDTO) {
		return sensorRepository.save(ConverterSensor.toEntity(sensorDTO)) != null;
	}

	public boolean updateSensor(SensorDTO sensorDTO) {
		return sensorRepository.save(ConverterSensor.toEntity(sensorDTO)) != null;
	}
	
	public void deleteSensorById(Integer idSensor) {
		sensorRepository.deleteById(idSensor);
	}
	
	public List<SensorDTO> findSensorDTOBySensorType(String sensorType) {
		
		final List<Sensor> list = sensorRepository.findAllBySensorType(sensorType);
		final List<SensorDTO> sensorDTOs = new ArrayList<>();
		list.forEach(i -> sensorDTOs.add(ConverterSensor.toDTO(i)));
		return sensorDTOs;
		
	
	}
}
