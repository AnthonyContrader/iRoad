package it.contrader.service;

import it.contrader.converter.ScreenConverter;
import it.contrader.dao.ScreenDAO;
import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;


public class ScreenService extends AbstractService<Screen, ScreenDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public ScreenService(){
		this.dao = new ScreenDAO();
		this.converter = new ScreenConverter();
	}
	

}
