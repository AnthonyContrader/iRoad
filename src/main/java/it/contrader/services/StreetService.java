package it.contrader.services;

import java.util.ArrayList;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterStreet;
import it.contrader.dao.StreetRepository;
import it.contrader.dto.StreetDTO;
import it.contrader.model.Street;


@Service
public class StreetService {

	private final StreetRepository streetRepository;

	@Autowired
	public StreetService(StreetRepository streetRepository) {
		this.streetRepository = streetRepository;
	}

	public List<StreetDTO> getListaStreetDTO() {
		return ConverterStreet.toListDTO((List<Street>) streetRepository.findAll());
	}

	public StreetDTO getStreetDTOById(Integer idStreet) {
		return ConverterStreet.toDTO(streetRepository.findById(idStreet).get());
	}

	public StreetDTO getByStreetNameAndstreettype(String streetName, String streetType) {

		final Street street = streetRepository.findStreetByStreetNameAndStreetType(streetName, streetType);
		

		return ConverterStreet.toDTO(street);
	}

	public boolean insertStreet(StreetDTO streetDTO) {
		return streetRepository.save(ConverterStreet.toEntity(streetDTO)) != null;
	}

	public boolean updateStreet(StreetDTO streetDTO) {
		return streetRepository.save(ConverterStreet.toEntity(streetDTO)) != null;
	}
	
	public void deleteStreetById(Integer id) {
		streetRepository.deleteById(id);
	}
	
	public List<StreetDTO> findStreetDTOByStreetname(String streetType) {
		
		final List<Street> list = streetRepository.findAllByStreetType(streetType);
		final List<StreetDTO> streetDTOs = new ArrayList<>();
		list.forEach(i -> streetDTOs.add(ConverterStreet.toDTO(i)));
		return streetDTOs;
		
	
	}
}
