package it.contrader.dto;
//Qui sotto definisco gli attributi di ScreenView. 


/*
 * Definisco i due costruttori, uno vuoto e uno con i parametri idscreen e output
 * per costrire oggetti di tipo ScreenView
 */
public class ScreenDTO {


	private int idScreen;
	
	private String output;

	public ScreenDTO() {

	}

	public ScreenDTO(String output) {;
		this.output = output;
	}
	
	public ScreenDTO(int idScreen, String output) {
		this.idScreen = idScreen;
		this.output = output;
	
	}

	public int getIdScreen() {
		return this.idScreen;
		
	}
    public void setIdScreen(int idScreen) {
		this.idScreen = idScreen;
	}

	public String getOutput() {
		return this.output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	/*
	 Definisco i Metodi Get e Set che servono alle altre classi a recuperare e modificare gli
	 * attributi di Screen
	 */
	@Override
	public String toString() {
		return idScreen + "\t\t" + output ;
	}

}