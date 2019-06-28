package it.contrader.view.sensor;

import it.contrader.controller.Request;
import it.contrader.dto.SensorDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

/**
 * 
 * @author Antonio
 *
 *Si osservi che alla View arrivano solo oggetti di tipo DTO!
 */
public class SensorReadView extends AbstractView {

	private int idSensor;
	private Request request;
	private final String mode = "READ";

	public SensorReadView() {
	}

	/**
	 * Se la request è null (ovvero quando arriva dal controller con mode GETCHOICE e choice L 
	 * il metodo è vuoto.
	 * 
	 * Altrimenti se arriva con un sensore nella request (ovvero quando arriva
	 * dal controller con mode READ) mostra il sensore. In questo caso torna alla SensorView senza eseguire
	 * gli altri due metodi
	 */
	@Override
	public void showResults(Request request) {
		if (request != null) {
			SensorDTO sensor = (SensorDTO) request.get("sensor");
			System.out.println(sensor);
			MainDispatcher.getInstance().callView("Sensor", null);
		}
	}

	
	/**
	 * chiede all'utente di inserire l'id del sensore da leggere
	 */
	@Override
	public void showOptions() {
		System.out.println("Inserisci l'ID dell'utente:");
		idSensor = Integer.parseInt(getInput());
	}

	/**
	 * impacchetta una request con l'id del sensore da leggere e la manda al controller tramite il Dispatcher
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idSensor", idSensor);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Sensor", "doControl", request);
	}

}
