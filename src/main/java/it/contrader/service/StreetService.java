package it.contrader.service;

import it.contrader.converter.StreetConverter;
import it.contrader.dao.StreetDAO;
import it.contrader.dto.StreetDTO;
import it.contrader.model.Street;

public class StreetService extends AbstractService<Street, StreetDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public StreetService(){
		this.dao = new StreetDAO();
		this.converter = new StreetConverter();
	}
	

}