package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.StreetDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Street;
import it.contrader.model.User;

public class ConverterStreet {

	public static StreetDTO toDTO(Street street) {
		StreetDTO streetDTO = null;
		if (street != null) {
			streetDTO = new StreetDTO();
			streetDTO.setIdStreet(street.getIdStreet());
			streetDTO.setStreetName(street.getStreetName());
			streetDTO.setStreetType(street.getStreetType());	
		}
		return streetDTO;
	}

	public static Street toEntity(StreetDTO streetDTO) {
		Street street = null;
		if (streetDTO != null) {
			street = new Street();
			street.setIdStreet(streetDTO.getIdStreet());
			street.setStreetName(streetDTO.getStreetName());
			street.setStreetType(streetDTO.getStreetType());
			
		}
		return street;
	}

	public static List<StreetDTO> toListDTO(List<Street> list) {
		List<StreetDTO> listStreetDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Street street : list) {
				listStreetDTO.add(ConverterStreet.toDTO(street));
			}
		}
		return listStreetDTO;
	}

	public static List<Street> toListEntity(List<StreetDTO> listStreetDTO) {
		List<Street> list = new ArrayList<>();
		if (!listStreetDTO.isEmpty()) {
			for (StreetDTO streetDTO : listStreetDTO) {
				list.add(ConverterStreet.toEntity(streetDTO));
			}
		}
		return list;
	}
}
