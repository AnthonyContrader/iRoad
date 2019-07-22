package it.contrader.dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import it.contrader.model.Vehicle.Vehicletype;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="idVehicle")
public class VehicleDTO {
	private long idVehicle;
	private Vehicletype vehicletype;
	private String nameVehicle;
	private Float speedVehicle;
	private Float weightVehicle;
	private Float longVehicle;
	private Float latVehicle;
}
