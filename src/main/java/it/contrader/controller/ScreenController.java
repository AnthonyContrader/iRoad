package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ScreenDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.service.ScreenService;

/**
 * 
 * @author iRoadteam
 *
 *Si osservi che nel Controller compaiono solo oggetti del DTO e non del Model!
 */
public class ScreenController implements Controller {

	/**
	 * definisce il pacchetto di vista user.
	 */
	private static String sub_package = "screen.";
	
	private ScreenService screenService;
	/**
	 * Costruisce un oggetto di tipo ScreenService per poterne usare i metodi
	 */
	public ScreenController() {
		this.screenService = new ScreenService();
	}
	
	
	
	/**
	 * Metodo dell'interfaccia Controller. Estrae dalla request la mode
	 * (che riceve dalle view specifiche e può essere la richesta di una 
	 * scelta da parte dell'utente "GETCHOICE") e la scelta dell'utente.
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
		int idScreen;
		String output;
		

		switch (mode) {
		
		// Arriva qui dalla ScreenReadView. Invoca il Service con il parametro id e invia alla ScreenReadView uno user da mostrare 
		case "READ":
			idScreen = Integer.parseInt(request.get("idScreen").toString());
			ScreenDTO ScreenDTO = screenService.read(idScreen);
			request.put("screen", ScreenDTO);
			MainDispatcher.getInstance().callView(sub_package + "ScreenRead", request);
			break;
		
		// Arriva qui dalla ScreenInsertView. Estrae i parametri da inserire e chiama il service per inserire uno user con questi parametri
		case "INSERT":
			output = request.get("output").toString();
			//costruisce l'oggetto screen da inserire
			ScreenDTO screentoinsert = new ScreenDTO(output);
			//invoca il service
			screenService.insert(screentoinsert);
			request = new Request();
			request.put("mode", "mode");
			//Rimanda alla view con la risposta
			MainDispatcher.getInstance().callView(sub_package + "ScreenInsert", request);
			break;
			
		// Arriva qui dalla UserDeleteView. Estrae l'id dell'utente da cancellare e lo passa al Service
					case "DELETE":
						idScreen = Integer.parseInt(request.get("idScreen").toString());
						//Qui chiama il service
						screenService.delete(idScreen);
						request = new Request();
						request.put("mode", "mode");
						MainDispatcher.getInstance().callView(sub_package + "UserDelete", request);
						break;
		
		// Arriva qui dalla ScreenUpdateView
		case "UPDATE":
			idScreen = Integer.parseInt(request.get("idScreen").toString());
			output = request.get("output").toString();
			ScreenDTO screentoupdate = new ScreenDTO(output);
			screentoupdate.setIdScreen(idScreen);
			screenService.update(screentoupdate);
			request = new Request();
			request.put("mode", "mode");
			MainDispatcher.getInstance().callView(sub_package + "ScreenUpdate", request);
			break;
			
		//Arriva qui dalla ScreenView Invoca il Service e invia alla ScreenView il risultato da mostrare 
		case "ScreenLIST":
			List<ScreenDTO> screensDTO = screenService.getAll();
			//Impacchetta la request con la lista degli output
			request.put("screens", screensDTO);
			MainDispatcher.getInstance().callView("Screen", request);
			break;
			
		//Esegue uno switch sulla base del comando inserito dall'utente e reindirizza tramite il Dispatcher alla View specifica per ogni operazione
		//con REQUEST NULL (vedi una View specifica)
		case "GETCHOICE":
					
					//toUpperCase() mette in maiuscolo la scelta
			switch (choice.toUpperCase()) {
			
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ScreenRead", null);
				break;
				
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ScreenUpdate", null);
				break;
				
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;

			case "B":
				MainDispatcher.getInstance().callView("HomeAdmin", null);
				break;
			
			
			}
			
		
		}
	}
}
