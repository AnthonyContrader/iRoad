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

	/*
	 Definisco i Metodi Get e Set che servono alle altre classi a recuperare e modificare gli
	 * attributi di Screen
	 */

}

