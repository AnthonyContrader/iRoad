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

public class Signal {

	@Id
	@Column(name = "idSignal")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idSignal;
	
	@Column(name = "signalType")
	@NotNull
	private String signalType;

	
}
