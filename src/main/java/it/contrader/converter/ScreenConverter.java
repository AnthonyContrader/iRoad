package it.contrader.converter;

import org.springframework.stereotype.Component;


import it.contrader.dto.ScreenDTO;

import it.contrader.model.Screen;

@Component
public class ScreenConverter extends AbstractConverter<Screen,ScreenDTO> {

	@Override
	public Screen toEntity(ScreenDTO screenDTO) {
		Screen screen = null;
		if (screenDTO != null) {
			screen = new Screen(screenDTO.getIdScreen(),screenDTO.getOutput());			
		}
		return screen;
	}

	@Override
	public ScreenDTO toDTO(Screen screen) {
		ScreenDTO screenDTO = null;
		if (screen != null) {
			screenDTO = new ScreenDTO(screen.getIdScreen(),screen.getOutput());
			
		}
		return screenDTO;
	}
}