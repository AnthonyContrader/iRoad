package it.contrader.view.screen;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class ScreenUpdateView extends AbstractView {
	private Request request;

	private int idScreen;
	private String output;

	private final String mode = "UPDATE";

	public ScreenUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Screen", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi dello screen da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci id dello screen:");
			idScreen = Integer.parseInt(getInput());
			System.out.println("Inserisci output dello screen:");
			output = getInput();
		
			
		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idScreen", idScreen);
		request.put("output", output);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Screen", "doControl", request);
	}

}
