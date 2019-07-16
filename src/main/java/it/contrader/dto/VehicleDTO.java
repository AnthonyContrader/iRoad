package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehicleDTO {

	private Integer idVehicle;

	private String nameVehicle;
	
	private String typeVehicle;

	private Float speedVehicle;
	
	private Float weightVehicle;
	
	private Float longVehicle;

	private Float latVehicle;
}
