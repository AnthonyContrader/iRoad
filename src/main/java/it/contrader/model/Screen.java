package it.contrader.model;

public class Screen {

// Qui sotto definisco gli attributi di ScreenView. 

	private int idScreen;
	private String output;

	/*
	 * Definisco i due costruttori, uno vuoto e uno con il parametro idscreenview
	 * per costrire oggetti di tipo ScreenView
	 */
	public Screen() {

	}

	public Screen(int idScreen, String output) {
		this.idScreen = idScreen;
		this.output = output;
	}

	/*
	 * Getter e Setter: servono alle altre classi a recuperare e modificare gli
	 * attributi di User
	 */
	public int getId() {
		return this.idScreen;
	}

	public void setId(int idScreenView) {
		this.idScreen = idScreen;
	}

	public void getOutput() {
		this.output = output;
	}
}


