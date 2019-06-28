package it.contrader.model;

public class Screen {

// Qui sotto definisco gli attributi di Screen. 
	
	private int idScreen;
	private String output;

	/*
	 * Definisco i due costruttori, uno vuoto e uno con i parametri idscreen e output
	 * per costrire oggetti di tipo Screen
	 */
	public Screen() {

	}

	public Screen(String output) {
		this.output = output;
	}

	public int getIdScreen() {
		return idScreen;
	}

	public void setIdScreen(int idScreen) {
		this.idScreen = idScreen;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public String toString() {
		return  idScreen + "\t" + output ;
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
		Screen other = (Screen) obj;
		if (idScreen != other.idScreen)
			return false;
		 else if (output.equals(other.output))
			return false;
		
		return true;
	}	

}

