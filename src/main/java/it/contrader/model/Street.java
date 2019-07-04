package it.contrader.model;

public class Street {
	
	// defisnisco gli attributi di strada 
	
	private int idstreet;
	
	private String streetname;
	
	private String streettype;
	
	// definisco i costruttori di tipo street 
	public Street() { 
		
	}
	
	public Street ( String streetname, String streettype) {
		this.streetname = streetname;
		this.streettype = streettype;
		
	}
	
	public Street (int idstreet, String streetname, String streettype) {
		this.streetname = streetname;
		this.streettype = streettype;
		
	}
	
	// Getter and Setter di Street 
	
	public int getIdstreet() {
		return this.idstreet;
	}
	
	public void setIdstreet(int idstreet) {
		this.idstreet = idstreet;
	
	}
	
	public String getStreetname() {
		return this.streetname;
		}
	
	public void setStreetname(String streetname) {
		this.streetname = streetname;
		
	}
	

	public String getStreettype() {
		return this.streettype;
		}
	
	public void setStreettype(String streettype) {
		this.streettype = streettype;
		
	}
	
	//trasforma un oggetto in una string 
	@Override
	
	public String toString() {
		return idstreet + "t\t" + streetname +"t\t" + streettype ;		
	}
	
	public boolean equals (Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Street other = (Street) obj;
		if (idstreet != other.idstreet)
			return false;
		if (streetname == null) {
			if (other.streetname!= null)
				return false;
		} else if (!streetname.equals(other.streetname))
			return false;
		
		return true;
	}
	
	
	
	
	

}
