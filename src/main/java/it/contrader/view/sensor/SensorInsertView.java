package it.contrader.view.sensor;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;
import it.contrader.view.AbstractView;

public class SensorInsertView extends AbstractView{
	private Request request;

	private String idSensor;
	private String SensorPosition;
	private String SensorType;
	private final String mode = "INSERT";

	public SensorInsertView() {
	}
	
	/**
	 * Se la request non è nulla (ovvero se si arriva dalla mode INSERT del controller) mostra
	 * l'esito dell'operazione
	 */
	@Override
	public void showResults(Request request) {
		if (request!=null) {
			System.out.println("Inserimento andato a buon fine.\n");
			MainDispatcher.getInstance().callView("Sensor", null);
		}
	}

	/**
	 * Chiede all'utente di inserire gli attributi del sensore da inserire
	 */
	@Override
	public void showOptions() {
			System.out.println("Inserisci l'ID del sensore:");
			idSensor = getInput();
			System.out.println("Inserisci la posizione del sensore:");
			SensorPosition = getInput();
			System.out.println("Inserisci tipo del sensore:");
			SensorType = getInput();
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
		request.put("mode",mode);
		MainDispatcher.getInstance().callAction("Sensor", "doControl", request);
	}


}
