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
public class Street {

	@Id
	@Column(name = "idStreet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStreet;

	@Column(name = "streetName")
	@NotNull
	private String streetName;

	@Column(name = "streetType")
	@NotNull
	private String streetType;



}
