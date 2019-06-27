package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

/**
 * Implementando questa l'interfaccia converter la classe SensorConverter è OBBLIGATA ad implementarne i metodi
 *
 */
public class SensorConverter  implements Converter<Sensor, SensorDTO> {
	
	/**
	 * Crea un oggetto di tipo SensorDTO e lo riempie con i campi del parametro sensor di tipo Sensor.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */

	public SensorDTO toDTO(Sensor sensor) {
		SensorDTO sensorDTO = new SensorDTO(sensor.getIdSensor(), sensor.getSensorPosition(), sensor.getSensorType());
		return sensorDTO;
	}

	/**
	 * Crea un oggetto di tipo Sensor e lo riempie con i campi del parametro sensor di tipo SensorDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Sensor toEntity(SensorDTO sensorDTO) {
		Sensor sensor = new Sensor(sensorDTO.getIdSensor(), sensorDTO.getSensorPosition(), sensorDTO.getSensorType());
		return sensor;
	}

	/**
	 * Metodo per convertire le liste di Sensor.
	 */
	@Override
	public List<SensorDTO> toDTOList(List<Sensor> sensorList) {
		//Crea una lista vuota.
		List<SensorDTO> sensorDTOList = new ArrayList<SensorDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Sensor sensor : sensorList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			sensorDTOList.add(toDTO(sensor));
		}
		return sensorDTOList;
	}

	
	
}
