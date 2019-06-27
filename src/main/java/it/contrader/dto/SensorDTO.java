package it.contrader.dto;

/**
 * 
 * @author Vittorio
 *
 *         Il DTO è simile al Model ma può contenere meno attributi (ad esempio
 *         d dati sensibili che non devono arrivare alla View). GLi oggetti
 *         vengono trasformati da oggetti del Model a oggetti del DTO tramite i
 *         Converter (chiamati dai Service). Per la descrizione della classe far
 *         riferimento al Model "User".
 */
public class SensorDTO {

	private int idSensor;

	private String SensorPosition; 

	private String SensorType;

	public SensorDTO() {

	}

	public SensorDTO(String SensorPosition, String SensorType) {
		this.SensorPosition = SensorPosition;
		this.SensorType = SensorType;

	}

	public SensorDTO (int idSensor, String SensorPosition, String SensorType) {
		this.idSensor = idSensor;
		this.SensorPosition = SensorPosition;
		this.SensorType = SensorType;
		
	}

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

	

	

	@Override
	public String toString() {
		return idSensor + "\t" + SensorPosition + "\t\t" + SensorType ;
	}
}
