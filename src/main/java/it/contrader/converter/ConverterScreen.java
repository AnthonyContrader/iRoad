package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

public class ConverterScreen {

	public static ScreenDTO toDTO(Screen screen) {
		ScreenDTO screenDTO = null;
		if (screen != null) {
			screenDTO = new ScreenDTO();
			screenDTO.setIdScreen(screen.getIdScreen());
			screenDTO.setOutput(screen.getOutput());					
		}
		return screenDTO;
	}

	public static Screen toEntity(ScreenDTO screenDTO) {
		Screen screen = null;
		if (screenDTO != null) {
			screen = new Screen();
			screen.setIdScreen(screenDTO.getIdScreen());
			screen.setOutput(screenDTO.getOutput());
		}
		return screen;
	}

	public static List<ScreenDTO> toListDTO(List<Screen> list) {
		List<ScreenDTO> listScreenDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Screen screen : list) {
				listScreenDTO.add(ConverterScreen.toDTO(screen));
			}
		}
		return listScreenDTO;
	}

	public static List<Screen> toListEntity(List<ScreenDTO> listScreenDTO) {
		List<Screen> list = new ArrayList<>();
		if (!listScreenDTO.isEmpty()) {
			for (ScreenDTO screenDTO : listScreenDTO) {
				list.add(ConverterScreen.toEntity(screenDTO));
			}
		}
		return list;
	}
}
