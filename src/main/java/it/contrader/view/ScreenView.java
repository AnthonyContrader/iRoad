package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.ScreenDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author iRoadteam
 *
 * Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class ScreenView extends AbstractView {

	private Request request;
	private String choice;

	public ScreenView() {
		
	}

	/**
	 * Mostra la lista output
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Screens ----------------\n");
			System.out.println("ID\tMessaggio di Output");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<ScreenDTO> screens = (List<ScreenDTO>) request.get("screens");
			for ( ScreenDTO sc: screens ) 
				System.out.println(sc);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi ScreenController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda allo UserController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Screen", "doControl", this.request);
	}

}
