package it.contrader.view.sensor;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SensorDeleteView extends AbstractView {
	private Request request;

	private int idSensor;
	private final String mode = "DELETE";

	public SensorDeleteView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode DELETE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Cancellazione andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Sensor", null);
		}
	}

	/**
	 * Chiede all'utente di inserire l'id del sensore da cancellare
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci id del sensore:");
			idSensor = Integer.parseInt(getInput());

	}

	/**
	 * impacchetta la request con l'id del sensore da cancellare
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idSensor", idSensor);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Sensor", "doControl", request);
	}


}
