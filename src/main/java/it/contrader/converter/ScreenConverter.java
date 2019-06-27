package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

/**
 * Implementando questa l'interfaccia converter la classe ScreenConverter è OBBLIGATA ad implementarne i metodi
 */
public class ScreenConverter  implements Converter<Screen, ScreenDTO> {
	/**
	 * Crea un oggetto di tipo ScreenDTO e lo riempie con i campi del parametro screen di tipo Screen.
	 */
	public ScreenDTO toDTO(Screen screen) {
		ScreenDTO screenDTO = new ScreenDTO(screen.getIdScreen(), screen.getOutput());
		return screenDTO;
	}

	/**
	 * Crea un oggetto di tipo User e lo riempie con i campi del parametro user di tipo ScreenDTO.
	 * Notare l'uso del metodo get() per ottenere il valore dell'attributo-
	 */

	public Screen toEntity(ScreenDTO screenDTO) {
		Screen screen = new Screen(screenDTO.getIdScreen(), screenDTO.getOutput());
		return screen;
	}
	
	/**
	 * Metodo per convertire le liste di Screen.
	 */

	public List<ScreenDTO> toDTOList(List<Screen> screenList) {
		//Crea una lista vuota.
		List<ScreenDTO> screenDTOList = new ArrayList<ScreenDTO>();
		
		//Cicla tutti gli elementi della lista e li converte uno a uno
		for(Screen screen : screenList) {
			//Utilizza il metodo toDTO per convertire ogni singolo elemento della lista
			//e lo aggiunge adda lista di DTO
			screenDTOList.add(toDTO(screen));
		}
		return screenDTOList;
	}

	
	
}
