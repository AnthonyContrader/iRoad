package it.contrader.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
	
	public enum Vehicletype {
		Autoveicolo,
		Autocarro,
		Motoveicolo,
		Velocipede
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idVehicle;
	@Column(unique = true)
	private Vehicletype vehicletype;
	private String nameVehicle;
	private Float speedVehicle;
	private Float weightVehicle;
	private Float longVehicle;
	private Float latVehicle;
}
