package it.contrader.view.sensor;


import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;


public class SensorUpdateView extends AbstractView {
	private Request request;

	private int idSensor;
	private String SensorPosition;
	private String SensorType;
	private final String mode = "UPDATE";

	public SensorUpdateView() {
	}

	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode UPDATE del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Modifica andata a buon fine.\n");
			MainDispatcher.getInstance().callView("Sensor", null);
		}
	}

	/**
	 * Chiede al sensore di inserire gli attributi del sensore da modificare
	 */
	@Override
	public void showOptions() {
		try {
			System.out.println("Inserisci l' id del sensore:");
			idSensor = Integer.parseInt(getInput());
			System.out.println("Inserisci Posizione del sensore:");
			SensorPosition = getInput();
			System.out.println("Inserisci tipo del sensore:");
			SensorType = getInput();

		} catch (Exception e) {

		}
	}


	/**
	 * Impacchetta la request con i dati inseriti nel metodo showOption()
	 */
	@Override
	public void submit() {
		request = new Request();
		request.put("idSensor", idSensor);
		request.put("SensorPosition", SensorPosition);
		request.put("SensorType", SensorType);
		request.put("mode", mode);
		MainDispatcher.getInstance().callAction("Sensor", "doControl", request);
	}

}
