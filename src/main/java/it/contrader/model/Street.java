package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Street {
	
	public enum Streettype {
		AUTOSTRADA,
		STRADASTATALE,
		STRADAREGIONALE,
		STRADACOMUNALE,
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idstreet;
	
	@Column(unique = true)
	private String streetname;
	private Streettype streettype;
	
	
	@ManyToOne
	@JoinColumn(name="Sensor_id")
	private Sensor sensor;
	
}
