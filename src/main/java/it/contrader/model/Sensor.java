package it.contrader.model;
/**
 * Per dettagli vedi guida sez 4 Model
 */
public class Sensor {

	/**
	 * Qui sotto definisco gli attributi di User. 
	 */
	private int idSensor;

	private String SensorPosition;
	
	private String SensorType;
	
	

	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo User
	 */
	public Sensor() {
		
	}

	public Sensor (String SensorPosition, String SensorType) {
	   	this.SensorPosition = SensorPosition;
	   	this.SensorType = SensorType;
		
	}

	public Sensor (int idSensor, String SensorPosition, String SensorType) {
		this.idSensor = idSensor;
		this.SensorPosition = SensorPosition;
		this.SensorType = SensorType;
		
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi di User
	 */
	public int getIdSensor() {
		return this.idSensor;
	}
	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}

	public String getSensorPosition() {
		return this.SensorPosition;
	}

	public void setSensorPosition(String SensorPosition) {
		this.SensorPosition = SensorPosition;
	}


	public String getSensorType() {
		return this.SensorType;
	}

	public void setSensorType(String SensorType) {
		this.SensorType = SensorType;
	}

	 

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  idSensor + "\t"  + SensorType +"\t\t" +  SensorPosition ;
	}

	//Metodo per il confronto degli oggetti
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sensor other = (Sensor) obj;
		if (idSensor != other.idSensor)
			return false;
		if (SensorPosition == null) {
			if (other.SensorPosition != null)
				return false;
		} else if (!SensorPosition.equals(other.SensorPosition))
			return false;
		
		return true;
	}
} 
