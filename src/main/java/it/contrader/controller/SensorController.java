package it.contrader.controller;

import java.util.List;

import it.contrader.dto.SensorDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.SensorService;

import it.contrader.dao.SensorDAO;
import it.contrader.model.Sensor;



/**
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class SensorController implements Controller {

	/**
	 * definisce il pacchetto di vista sensor.
	 */
	private static String sub_package = "sensor.";
	
	private SensorService sensorService;
	/**
	 * Costruisce un oggetto di tipo SensorService per poterne usare i metodi
	 */
	public SensorController() {
		this.sensorService = new SensorService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta del sensore.
	 * 
	 * Se la modalità corrisponde ad una CRUD il controller chiama i service,
	 * altrimenti rimanda alla View della CRUD per richiedere i parametri
	 */
	@Override
	public void doControl(Request request) {
		
		//Estrae dalla request mode e choice
		String mode = (String) request.get("mode");
		
		String choice = (String) request.get("choice");

		//Definisce i campi della classe (serviranno sempre, tanto vale definirli una sola volta)
		int idSensor;
		String SensorPosition;
		String SensorType;

		switch (mode) {
		
		// Arriva qui dalla SensorReadView. Invoca il Service con il parametro idSensor e invia alla SensorReadView un sensore da mostrare 
		case "READ":
			idSensor = Integer.parseInt(request.get("idSensor").toString());
			SensorDTO sensorDTO = sensorService.read(idSensor);
			request.put("sensor", sensorDTO);
			MainDispatcher.getInstance().callView(sub_package + "SensorRead", request);
			break;
		
		// Arriva qui dalla SensorInsertView. Estrae i parametri da inserire e chiama il service per inserire un sensore con questi parametri
		case "INSERT":
			idSensor = Integer.parseInt(request.get("idSensor").toString());
			SensorPosition = request.get("SensorPosition").toString();
			SensorType = request.get("SensorType").toString();
			//costruisce l'oggetto sensore da inserire
			SensorDTO sensortoinsert = new SensorDTO(idSensor, SensorPosition, SensorType);
			//invoca il service
			sensorService.insert(sensortoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "SensorInsert", request);
			break;
		
		// Arriva qui dalla SensorDeleteView. Estrae l'id del sensore da cancellare e lo passa al Service
		case "DELETE":
			idSensor = Integer.parseInt(request.get("idSensor").toString());
			//Qui chiama il service
			sensorService.delete(idSensor);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SensorDelete", request);
			break;
		
		// Arriva qui dalla UserUpdateView
		case "UPDATE":
			idSensor = Integer.parseInt(request.get("idSensor").toString());
			SensorPosition = request.get("SensorPosition").toString();
			SensorType = request.get("SensorType").toString();
			SensorDTO sensortoupdate = new SensorDTO(idSensor, SensorPosition, SensorType);
			sensortoupdate.setIdSensor(idSensor);
			sensorService.update(sensortoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "SensorUpdate", request);
			break;
			
		//Arriva qui dalla SensorView Invoca il Service e invia alla SensorView il risultato da mostrare 
		case "SENSORLIST":
			List<SensorDTO> sensorsDTO = sensorService.getAll();
			//Impacchetta la request con la lista del sensore
			request.put("sensors", sensorsDTO);
			MainDispatcher.getInstance().callView("Sensor", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "SensorRead", null);
				break;
				
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "SensorInsert", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "SensorUpdate", null);
				break;
				
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "SensorDelete", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
				
			default:
				MainDispatcher.getInstance().callView("Login", null);
			}
			
		default:
			MainDispatcher.getInstance().callView("Login", null);
		}
	}
}
