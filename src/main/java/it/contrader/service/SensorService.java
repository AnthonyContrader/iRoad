package it.contrader.service;

import it.contrader.converter.SensorConverter;
import it.contrader.dao.SensorDAO;
import it.contrader.dto.SensorDTO;
import it.contrader.model.Sensor;

/**
 * 
 * @author Antonio
 *
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class SensorService extends AbstractService<Sensor, SensorDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public SensorService(){
		this.dao = new SensorDAO();
		this.converter = new SensorConverter();
	}
	

}
