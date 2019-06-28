package it.contrader.view;

import java.util.List;

import it.contrader.controller.Request;
import it.contrader.dto.SensorDTO;
import it.contrader.main.MainDispatcher;


/**
 * 
 * @author Antonio
 *
 * Alla View arrivano solo oggetti di tipo DTO!
 */
public class SensorView extends AbstractView {

	private Request request;
	private String choice;

	public SensorView() {
		
	}

	/**
	 * Mostra la lista Sensor
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			System.out.println("\n------------------- Gestione Sensori ----------------\n");
			System.out.println("ID\tSensorPosition\tSensorType");
			System.out.println("----------------------------------------------------\n");
			
			@SuppressWarnings("unchecked")
			List<SensorDTO> sensors = (List<SensorDTO>) request.get("sensors");
			for (SensorDTO s: sensors)
				System.out.println(s);
			System.out.println();
		}
	}

	/**
	 * Chiede all'utente un input (lettera da tastiera) per la choice (vedi UserController). 
	 * Mette la modalità GETCHOICE nella mode.
	 */
	@Override
	public void showOptions() {
		System.out.println("          Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [B]ack [E]sci");

		this.choice = getInput();

		
	}
	
	/**
	 * Impacchetta la request e la manda al ServerController.
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "GETCHOICE");
		MainDispatcher.getInstance().callAction("Sensor", "doControl", this.request);
	}

}
