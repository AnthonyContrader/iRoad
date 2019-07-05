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

	public VehicleDTO (String nameVehicle, String typeVehicle, double speedVehicle, double weightVehicle,double longVehicle, double latVehicle) {
		this.nameVehicle = nameVehicle;
		this.typeVehicle = typeVehicle;
		this.speedVehicle = speedVehicle;
		this.weightVehicle = weightVehicle;
		this.longVehicle = longVehicle;
		this.latVehicle = latVehicle;
	}

	public VehicleDTO (int idVehicle, String nameVehicle, String typeVehicle,  double speedVehicle, double weightVehicle,double longVehicle, double latVehicle ) {
		this.idVehicle = idVehicle;
		this.nameVehicle = nameVehicle;
		this.typeVehicle = typeVehicle;
		this.speedVehicle = speedVehicle;
		this.weightVehicle = weightVehicle;
		this.longVehicle = longVehicle;
		this.latVehicle = latVehicle;
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
	public void setSpeedVehicle(double speedVehicle) {
		this.speedVehicle = speedVehicle;
	}
	
	public double getWeightVehicle() {
		return this.weightVehicle;
	}
	public void setWeightVehicle(double weightVehicle) {
		this.weightVehicle = weightVehicle;
	}


	public double getLongVehicle() {
		return this.longVehicle;
	}
	public void setLongVehicle(double longVehicle) {
		this.longVehicle = longVehicle;
	}
	
	public double getLatVehicle() {
		return this.latVehicle;
	}
	public void setLatVehicle(double latVehicle) {
		this.latVehicle = latVehicle;
	}
	
	@Override
	public String toString() {
		return  idVehicle + "\t"  + nameVehicle +"\t\t"+ "\t\t" + typeVehicle + "\t\t" + speedVehicle + "\t\t" + weightVehicle + "\t\t" +  longVehicle  + "\t\t" + latVehicle;
	}
}
