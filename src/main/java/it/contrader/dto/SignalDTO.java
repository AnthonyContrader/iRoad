package it.contrader.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SignalDTO {
	
	private Integer idSignal;

	private String signalType;

}
