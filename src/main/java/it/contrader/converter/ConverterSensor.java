package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

public class ConverterSensor {

	public static SensorDTO toDTO(Sensor sensor) {
		SensorDTO sensorDTO = null;
		if (sensor != null) {
			sensorDTO = new SensorDTO();
			sensorDTO.setIdSensor(sensor.getIdSensor());
			sensorDTO.setLongSensor(sensor.getLongSensor());
			sensorDTO.setLatSensor(sensor.getLatSensor());
			sensorDTO.setSensorType(sensor.getSensorType());			
		}
		return sensorDTO;
	}

	public static Sensor toEntity(SensorDTO sensorDTO) {
		Sensor sensor = null;
		if (sensorDTO != null) {
			sensor = new Sensor();
			sensor.setIdSensor(sensorDTO.getIdSensor());
			sensor.setLongSensor(sensorDTO.getLongSensor());
			sensor.setLatSensor(sensorDTO.getLatSensor());
			sensor.setSensorType(sensorDTO.getSensorType());
		}
		return sensor;
	}

	public static List<SensorDTO> toListDTO(List<Sensor> list) {
		List<SensorDTO> listSensorDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Sensor sensor : list) {
				listSensorDTO.add(ConverterSensor.toDTO(sensor));
			}
		}
		return listSensorDTO;
	}

	public static List<Sensor> toListEntity(List<SensorDTO> listSensorDTO) {
		List<Sensor> list = new ArrayList<>();
		if (!listSensorDTO.isEmpty()) {
			for (SensorDTO sensorDTO : listSensorDTO) {
				list.add(ConverterSensor.toEntity(sensorDTO));
			}
		}
		return list;
	}
}
