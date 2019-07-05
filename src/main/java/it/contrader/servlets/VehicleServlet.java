package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.VehicleDTO;
import it.contrader.service.Service;
import it.contrader.service.VehicleService;

/*
 * Per dettagli vedi Guida sez Servlet
 */
public class VehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public VehicleServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<VehicleDTO> service = new VehicleService();
		List<VehicleDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<VehicleDTO> service = new VehicleService();
		String mode = request.getParameter("mode");
		VehicleDTO dto;
		int idVehicle;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "VEHICLELIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/vehicle/vehiclemanager.jsp").forward(request, response);
			break;

		case "READ":
			idVehicle = Integer.parseInt(request.getParameter("idVehicle"));
			dto = service.read(idVehicle);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/vehicle/readvehicle.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/vehicle/updatecehicle.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String nameVehicle = request.getParameter("nameVehicle").toString();
			String typeVehicle = request.getParameter("typeVehicle").toString();
			double speedVehicle = Double.parseDouble(request.getParameter("speedVehicle").toString());
			double weightVehicle = Double.parseDouble(request.getParameter("weightVehicle").toString());
			double longVehicle = Double.parseDouble(request.getParameter("longVehicle").toString());
			double latVehicle = Double.parseDouble(request.getParameter("latVehicle").toString());
			
			
			dto = new VehicleDTO (nameVehicle,typeVehicle,speedVehicle,weightVehicle,longVehicle,latVehicle);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/vehicle/vehiclemanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			nameVehicle = request.getParameter("nameVehicle");
			typeVehicle = request.getParameter("typeVehicle");
			speedVehicle = Double.parseDouble(request.getParameter("speedVehicle"));
			weightVehicle = Double.parseDouble(request.getParameter("weightVehicle"));
			longVehicle = Double.parseDouble(request.getParameter("longVehicle"));
			latVehicle = Double.parseDouble(request.getParameter("latVehicle"));
			
			
			idVehicle = Integer.parseInt(request.getParameter("idVehicle"));
			dto = new VehicleDTO (idVehicle,nameVehicle, typeVehicle, speedVehicle, weightVehicle, longVehicle,latVehicle);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/vehicle/vehiclemanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idVehicle = Integer.parseInt(request.getParameter("idVehicle"));
			ans = service.delete(idVehicle);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/vehicle/vehiclemanager.jsp").forward(request, response);
			break;
		}
	}
}