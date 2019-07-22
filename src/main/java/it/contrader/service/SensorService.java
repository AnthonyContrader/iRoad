package it.contrader.service;

import org.springframework.stereotype.Service;

import it.contrader.dao.SensorRepository;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

@Service
public class SensorService extends AbstractService<Sensor,SensorDTO> {
	
	public SensorDTO findBySensortype(String sensortype) {
		return converter.toDTO(((SensorRepository)repository).findBySensortype(sensortype));
	}

}
