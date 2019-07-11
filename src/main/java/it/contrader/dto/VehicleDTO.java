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

	private Double speedVehicle;
	
	private Double weightVehicle;
	
	private Double longVehicle;

	private Double latVehicle;
}
