package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SensorDTO {

	private Integer idSensor;

	private Float longSensor;
	
	private Float latSensor;

	private String sensorType;
	
	
}
