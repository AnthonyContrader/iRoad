package it.contrader.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.contrader.dto.StreetDTO;

import it.contrader.model.Street;

@Component
public class StreetConverter extends AbstractConverter<Street,StreetDTO> {
    
	@Autowired
	SensorConverter converter;
	
	@Override
	public Street toEntity(StreetDTO streetDTO) {
		Street street = null;
		if (streetDTO != null) {
			street = new Street();			
			street.setIdstreet(streetDTO.getIdstreet());
			street.setStreetname(streetDTO.getStreetname());
			street.setStreettype(streetDTO.getStreettype());
			street.setSensor(converter.toEntity(streetDTO.getSensorDTO()));
		}
		return street;
	}

	@Override
	public StreetDTO toDTO(Street street) {
		StreetDTO streetDTO = null;
		if (street != null) {
			streetDTO = new StreetDTO(street.getIdstreet(),street.getStreetname(),street.getStreettype(),converter.toDTO(street.getSensor()));
		
		}
		return streetDTO;
	}
}