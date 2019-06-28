package it.contrader.view.screen;

import it.contrader.controller.Request;

import it.contrader.dto.ScreenDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author iRoadteam
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class ScreenReadView extends AbstractView {

	private int idScreen;
	private Request request;
	private final String mode = "READ";

	public ScreenReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con uno screen nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra lo screen. In questo caso torna alla UserView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			ScreenDTO screen = (ScreenDTO) request.get("screen");
			System.out.println(screen);
			MainDispatcher.getInstance().callView("Screen", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id dello screen da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dello screen:");
		idScreen = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id dello screen da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idScreen", idScreen);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Screen", "doControl", request);
	}

}
