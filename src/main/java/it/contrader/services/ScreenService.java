package it.contrader.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterScreen;
import it.contrader.dao.ScreenRepository;
import it.contrader.dto.ScreenDTO;
import it.contrader.model.Screen;

@Service
public class ScreenService {

	private final ScreenRepository screenRepository;

	@Autowired
	public ScreenService(ScreenRepository screenRepository) {
		this.screenRepository = screenRepository;
	}

	public List<ScreenDTO> getListaScreenDTO() {
		return ConverterScreen.toListDTO((List<Screen>) screenRepository.findAll());
	}

	public ScreenDTO getScreenDTOById(Integer idScreen) {
		return ConverterScreen.toDTO(screenRepository.findById(idScreen).get());
	}

	public ScreenDTO getByOutput(String output) {

		final Screen screen = screenRepository.findScreenByOutput(output);

		return ConverterScreen.toDTO(screen);
	}

	public boolean insertScreen(ScreenDTO screenDTO) {
		return screenRepository.save(ConverterScreen.toEntity(screenDTO)) != null;
	}

	public boolean updateScreen(ScreenDTO screenDTO) {
		return screenRepository.save(ConverterScreen.toEntity(screenDTO)) != null;
	}
	
	public void deleteScreenById(Integer idScreen) {
		screenRepository.deleteById(idScreen);
	}
	
	public List<ScreenDTO> findScreenDTOByOutput(String output){
		
		final List<Screen> list = screenRepository.findAllByOutput(output);
		final List<ScreenDTO> screenDTOs = new ArrayList<>();
		list.forEach(i -> screenDTOs.add(ConverterScreen.toDTO(i)));
		return screenDTOs;
		
	
	}
}
