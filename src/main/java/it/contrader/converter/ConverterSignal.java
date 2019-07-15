package it.contrader.converter;

import java.util.ArrayList;

import java.util.List;

import it.contrader.dto.SignalDTO;
import it.contrader.model.Signal;

public class ConverterSignal {

	public static SignalDTO toDTO(Signal signal) {
		SignalDTO signalDTO = null;
		if (signal != null) {
			signalDTO = new signalDTO();
			signalDTO.setIdsignal(signal.getIdsignal());
			signalDTO.setsignalType(signal.getsignalType());
		}
		
		return signalDTO;
	}

	public static signal toEntity(signalDTO signalDTO) {
		signal signal = null;
		if (signalDTO != null) {
			signal = new signal();
			signal.setIdsignal(signalDTO.getIdsignal());		
			signal.setsignalType(signalDTO.getSignalType());
		}
		return signal;
	}

	public static List<signalDTO> toListDTO(List<signal> list) {
		List<signalDTO> listsignalDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (signal signal : list) {
				listSignalDTO.add(Convertersignal.toDTO(signal));
			}
		}
		return listSignalDTO;
	}

	public static List<signal> toListEntity(List<signalDTO> listsignalDTO) {
		List<signal> list = new ArrayList<>();
		if (!listsignalDTO.isEmpty()) {
			for (signalDTO signalDTO : listsignalDTO) {
				list.add(ConverterSignal.toEntity(signalDTO));
			}
		}
		return list;
	}
}
