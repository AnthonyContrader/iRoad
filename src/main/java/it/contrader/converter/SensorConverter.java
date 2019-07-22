package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.SensorDTO;

import it.contrader.model.Sensor;

@Component
public class SensorConverter extends AbstractConverter<Sensor,SensorDTO> {

	@Override
	public Sensor toEntity(SensorDTO sensorDTO) {
		Sensor sensor = null;
		if (sensorDTO != null) {
			sensor = new Sensor(sensorDTO.getIdSensor(),sensorDTO.getLongSensor(),sensorDTO.getLatSensor(),sensorDTO.getSensortype());			
		}
		return sensor;
	}

	@Override
	public SensorDTO toDTO(Sensor sensor) {
		SensorDTO sensorDTO = null;
		if (sensor != null) {
			sensorDTO = new SensorDTO(sensor.getIdSensor(),sensor.getLongSensor(),sensor.getLatSensor(),sensor.getSensortype());
			
		}
		return sensorDTO;
	}
}