package it.contrader.dto;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StreetDTO {

	private Integer idStreet;

	private String streetName;
	
	private String streetType;

	
}
