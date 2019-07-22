package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.StreetDTO;

import it.contrader.model.Street;

@Component
public class StreetConverter extends AbstractConverter<Street,StreetDTO> {

	@Override
	public Street toEntity(StreetDTO streetDTO) {
		Street street = null;
		if (streetDTO != null) {
			street = new Street(streetDTO.getIdstreet(),streetDTO.getStreetname(),streetDTO.getStreettype());			
		}
		return street;
	}

	@Override
	public StreetDTO toDTO(Street street) {
		StreetDTO streetDTO = null;
		if (street != null) {
			streetDTO = new StreetDTO(street.getIdstreet(),street.getStreetname(),street.getStreettype());
			
		}
		return streetDTO;
	}
}