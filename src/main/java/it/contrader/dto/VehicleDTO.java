package it.contrader.dto;

/**
 * 
 * @author Tunzis
 *
 *Il DTO è simile al Model ma può contenere meno attributi (ad esempio d dati sensibili
 *che non devono arrivare alla View). GLi oggetti vengono trasformati da oggetti del Model
 *a oggetti del DTO tramite i Converter (chiamati dai Service). 
 *Per la descrizione della classe far riferimento al Model "Vehicle".
 */
public class VehicleDTO {
	
	private int idVehicle;

	private String nameVehicle;
	
	private String typeVehicle;
	
	private double speedVehicle;
	
	private double weightVehicle;
	
	private double latVehicle;
	
	private double longVehicle;
	
	

	
	public VehicleDTO() {
		
	}

	public VehicleDTO (String nameVehicle, String typeVehicle, double speedVehicle, double weightVehicle, double latVehicle, double longVehicle) {
		this.nameVehicle = nameVehicle;
		this.typeVehicle = typeVehicle;
		this.speedVehicle = speedVehicle;
		this.weightVehicle = weightVehicle;
		this.latVehicle = latVehicle;
		this.longVehicle = longVehicle;
	}

	public VehicleDTO (int idVehicle, String nameVehicle, String typeVehicle,  double speedVehicle, double weightVehicle, double latVehicle, double longVehicle) {
		this.idVehicle = idVehicle;
		this.nameVehicle = nameVehicle;
		this.typeVehicle = typeVehicle;
		this.speedVehicle = speedVehicle;
		this.weightVehicle = weightVehicle;
		this.latVehicle = latVehicle;
		this.longVehicle = longVehicle;
	}

	public int getIdVehicle() {
		return this.idVehicle;
	}
	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}
	
	public String getNameVehicle() {
		return this.nameVehicle;
	}
	
	public void setNameVehicle(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}

	

	public String getTypeVehicle() {
		return this.typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
	
	public double getSpeedVehicle() {
		return this.speedVehicle;
	}
	public void setSpeedVehicle(int speedVehicle) {
		this.speedVehicle = speedVehicle;
	}
	
	public double getWeightVehicle() {
		return this.weightVehicle;
	}
	public void setWeightVehicle(int weightVehicle) {
		this.weightVehicle = weightVehicle;
	}

	public double getLatVehicle() {
		return this.latVehicle;
	}
	public void setLatVehicle(int latVehicle) {
		this.latVehicle = latVehicle;
	}

	public double getLongVehicle() {
		return this.longVehicle;
	}
	public void setLongVehicle(int longVehicle) {
		this.longVehicle = longVehicle;
	}
	
	@Override
	public String toString() {
		return  idVehicle + "\t"  + nameVehicle +"\t\t"+ "\t\t" + typeVehicle + "\t\t" + speedVehicle + "\t\t" + weightVehicle + "\t\t" + latVehicle + "\t\t" + longVehicle;
	}
}
