package it.contrader.model;
/**
 * 
 * @author Tunzis
 * 
 * Per dettagli vedi guida sez 4 Model
 */
public class Vehicle {

	/**
	 * Qui sotto definisco gli attributi di Vehicle. 
	 */
	private int idVehicle;   //private int id;

	private String nameVehicle; // private String username;
								// private String password;
	private String typeVehicle; // private String usertype;
	
	private double speedVehicle;   // private int userSpeed;
	
	private double weightVehicle;  // private int userWeight;
	
	private double latVehicle;  // new
	
	private double longVehicle;  // new
	
	/*  COSE AGGIUNTE
			int   		idVehicle
			string		nameVehicle
			string		typeVehicle
			double		speedVehicle
			double		weightVehicle
			double		latVehicle
			double		longVehicle
    */
	
	
	
	/**
	 * Definisco i due costruttori, uno vuoto e uno con tre parametri per costrire oggetti di tipo Vehicle
	 */
	public Vehicle() {
		
	}

	public Vehicle (String nameVehicle, String typeVehicle, double speedVehicle, double weightVehicle, double latVehicle, double longVehicle) {
		this.nameVehicle = nameVehicle;
		this.typeVehicle = typeVehicle;
		this.speedVehicle = speedVehicle;
		this.weightVehicle = weightVehicle;
		this.weightVehicle = latVehicle;
		this.weightVehicle = longVehicle;
	}

	public Vehicle (int idVehicle, String nameVehicle, String typeVehicle, double speedVehicle, double weightVehicle, double latVehicle, double longVehicle) {
		this.idVehicle = idVehicle;
		this.nameVehicle = nameVehicle;
		this.typeVehicle = typeVehicle;
		this.speedVehicle = speedVehicle;
		this.weightVehicle = weightVehicle;
		this.weightVehicle = latVehicle;
		this.weightVehicle = longVehicle;
	}

	/**
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli attributi del Veicolo
	 */
	public int getIdVehicle() {
		return this.idVehicle;
	}
	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}

	public String getTypeVehicle() {
		return this.typeVehicle;
	}

	public void setTypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}

	public void setNameVehicle(String nameVehicle) {
		this.nameVehicle = nameVehicle;
	}

	public String getNameVehicle() {
		return nameVehicle;
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

	public double getLatVehicle() {
		return this.latVehicle;
	}
	public void setLatVehicle(double latVehicle) {
		this.latVehicle = latVehicle;
	}

	public double getLongVehicle() {
		return this.longVehicle;
	}
	public void setLongVehicle(double longVehicle) {
		this.longVehicle = longVehicle;
	}

	//Trasforma un oggetto in una stringa
	@Override
	public String toString() {
		return  idVehicle + "\t"  + nameVehicle + "\t\t" + typeVehicle + "\t\t" + speedVehicle + "\t\t" + weightVehicle + "\t\t" + latVehicle + "\t\t" + longVehicle;
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
		Vehicle other = (Vehicle) obj;
		if (idVehicle != other.idVehicle)
			return false;
		if (nameVehicle == null) {
			if (other.nameVehicle != null)
				return false;
		} else if (!nameVehicle.equals(other.nameVehicle))
			return false;
		if (typeVehicle == null) {
			if (other.typeVehicle != null)
				return false;
		} else if (!typeVehicle.equals(other.typeVehicle))
			return false;
		return true;
	}
}
