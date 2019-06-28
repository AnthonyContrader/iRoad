package it.contrader.view.screen;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ScreenInsertView extends AbstractView{
	private Request request;

	private String output;
	private final String mode = "INSERT";

	public ScreenInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Screen", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dello screen da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci il messaggio");
			output = getInput();
			
			
			
	}

	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("output", output);
		request.put("mode", mode);
		
	
		MainDispatcher.getInstance().callAction("Screen", "doControl", request);
	}


}
