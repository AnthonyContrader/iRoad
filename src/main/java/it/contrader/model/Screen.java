package it.contrader.model;

public class Screen {

// Qui sotto definisco gli attributi di Screen. 
	
	private int idScreen;
	private String output;

	/*
	 * Definisco i due costruttori, uno vuoto e uno con i parametri idscreen e output
	 * per inizializzare i campi di Screen in uno stato noto
	 */
	public Screen() {

	}

	public Screen(String output) {
		this.output = output;
	}
	public Screen(int idScreen, String output) {
		this.idScreen = idScreen;
		this.output = output;
	}
    /*
     * inserisco i metodi get e set che verranno usati dalle altre classi per accedere agli attributi
     * privati della classe Screen
     */
	
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
//trasformo gli oggetti di Screen in stringa per poter essere visualizzati nella console
	public String toString() {
		return  idScreen + "\t" + output;
	}
	
	//Metodo per il confronto degli oggetti

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Screen other = (Screen) obj;
		if (this.idScreen != other.idScreen)
			return false;
		if (!this.getOutput().equals(other.getOutput())) return false;
		return true;
	}	
}

