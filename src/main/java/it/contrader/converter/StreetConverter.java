package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.StreetDTO;
import it.contrader.model.Street;

//Implementando questa l'interfaccia converter la classe ScreenConverter è OBBLIGATA ad implementarne i metodi

public class StreetConverter  implements Converter<Street, StreetDTO> {
	/**
	 * Crea un oggetto di tipo StreetDTO e lo riempie con i campi del parametro screen di tipo Screen.
	 */
	public StreetDTO toDTO(Street street) {
		StreetDTO streetDTO = new StreetDTO(street.getIdstreet(), street.getStreetname(), street.getStreettype());
		return streetDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo StreetDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */
	@Override
	public Street toEntity(StreetDTO streetDTO) {
		Street street = new Street( streetDTO.getIdStreet(), streetDTO.getStreetname(), streetDTO.getStreettype());
		return street;
	}
	
	/**
	 * Metodo per convertire le liste di Street.
	 */
	@Override
	public List<StreetDTO> toDTOList(List<Street> streetList) {
		//Crea una lista vuota.
		List<StreetDTO> streetDTOList = new ArrayList<StreetDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Street street : streetList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			streetDTOList.add(toDTO(street));
		}
		return streetDTOList;
	}

	
	
}

