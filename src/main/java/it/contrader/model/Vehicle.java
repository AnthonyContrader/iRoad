package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vehicle {

	@Id
	@Column(name = "idVehicle")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idVehicle;

	@Column(name = "nameVehicle")
	@NotNull
	private String nameVehicle;

	@Column(name = "typeVehicle")
	@NotNull
	private String typeVehicle;

	@NotNull
	@Column(name = "speedVehicle")
	private Double speedVehicle;

	
	@Column(name = "weightVehicle")
	private Double weightVehicle;
    
	@Column(name = "longVehicle")
	private Double longVehicle;
	
	@Column(name = "latVehicle")
	private Double latVehicle;
	
	
}
