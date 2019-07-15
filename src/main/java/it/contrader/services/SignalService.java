package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import it.contrader.converter.ConverterSignal;
import it.contrader.dao.SignalRepository;
import it.contrader.dto.SignalDTO;
import it.contrader.model.Signal;

@Signal

public class SignalService {
	
	@Autowired
	public SignalService(SignalRepository signalRepository) {
		this.signalRepository = signalRepository;
	}

	public List<SignalDTO> getListaSignalDTO() {
		return ConverterSignal.toListDTO((List<Signal>) signalRepository.findAll());
	}
	
}
