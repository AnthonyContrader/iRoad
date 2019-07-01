package it.contrader.service;

import it.contrader.converter.UserConverter;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

public class UserService extends AbstractService<User, UserDTO> {
	
	//Istanzio DAO  e Converter specifici.
	public UserService(){
		this.dao = new UserDAO();
		this.converter = new UserConverter();
	}
	

}
