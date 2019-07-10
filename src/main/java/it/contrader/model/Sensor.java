package it.contrader.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sensor {

	@Id
	@Column(name = "idSensor")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSensor;

	@Column(name = "sensorPosition")
	@NotNull
	private String sensorPosition;

	@Column(name = "sensorType")
	@NotNull
	private String sensorType;

}
