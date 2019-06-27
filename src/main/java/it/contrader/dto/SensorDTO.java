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

	private String Sensor_position; 

	private String Sensor_type;

	public SensorDTO() {

	}

	public SensorDTO(String Sensor_position, String Sensor_type) {
		this.Sensor_position = Sensor_position;
		this.Sensor_type = Sensor_type;

	}

	public SensorDTO (int idSensor, String Sensor_position, String Sensor_type) {
		this.idSensor = idSensor;
		this.Sensor_position = Sensor_position;
		this.Sensor_type = Sensor_type;
		
	}

	public int getIdSensor() {
		return this.idSensor;
	}

	public void setIdSensor(int idSensor) {
		this.idSensor = idSensor;
	}

	public String getSensor_position() {
		return this.Sensor_position;
	}

	public void setSensor_position(String Sensor_position) {
		this.Sensor_position = Sensor_position;
	}

	public String getSensor_type() {
		return this.Sensor_type;
	}

	public void setSensor_type(String Sensor_type) {
		this.Sensor_type = Sensor_type;
	}

	

	

	@Override
	public String toString() {
		return idSensor + "\t" + Sensor_position + "\t\t" + Sensor_type ;
	}
}
