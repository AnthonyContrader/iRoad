package it.contrader.service;

import it.contrader.converter.ScreenConverter;
import it.contrader.dao.ScreenDAO;
import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

/**
 *Grazie all'ereditarietà mi basta specificare i tipi di questa classe per
 *ereditare i metodi della clase AbstractService. Pertanto la classe risulta meno complicata
 *da scrivere, facendoci risparmiare tempo e fatica!
 */
public class ScreenService extends AbstractService<Screen, ScreenDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public ScreenService(){
		this.dao = new ScreenDAO();
		this.converter = new ScreenConverter();
	}
	

}
