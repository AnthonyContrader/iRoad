package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.SensorDTO;
import it.contrader.service.Service;
import it.contrader.service.SensorService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class SensorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SensorServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<SensorDTO> service = new SensorService();
		List<SensorDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<SensorDTO> service = new SensorService();
		String mode = request.getParameter("mode");
		SensorDTO dto;
		int idSensor;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "SENSORLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(request, response);
			break;

		case "READ":
			idSensor = Integer.parseInt(request.getParameter("idSensor"));
			dto = service.read(idSensor);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/sensor/readsensor.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/sensor/updatesensor.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String SensorPosition = request.getParameter("SensorPosition").toString();
			String SensorType = request.getParameter("SensorType").toString();
			dto = new SensorDTO (SensorPosition,SensorType);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			SensorPosition = request.getParameter("SensorPosition");
			SensorType = request.getParameter("SensorType");
			idSensor = Integer.parseInt(request.getParameter("idSensor"));
			dto = new SensorDTO (idSensor, SensorPosition, SensorType);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idSensor = Integer.parseInt(request.getParameter("idSensor"));
			ans = service.delete(idSensor);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/sensor/sensormanager.jsp").forward(request, response);
			break;
		}
	}
}