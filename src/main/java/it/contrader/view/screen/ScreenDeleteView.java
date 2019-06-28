package it.contrader.view.screen;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class ScreenDeleteView extends AbstractView {
	private Request request;

	private int idScreen;
	private final String mode = "DELETE";

	public ScreenDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Screen", null);
		}
	}

	/**
	 * Chiede allo screen di inserire l'id dello screen da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id dello screen:");
			idScreen = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id dello screen da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idScreen", idScreen);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Screen", "doControl", request);
	}


}
