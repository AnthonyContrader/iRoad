package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.VehicleDTO;
import it.contrader.services.VehicleService;

import java.util.List;


@Controller
@RequestMapping("/Vehicle")
public class VehicleController {

	private final VehicleService vehicleService;
	private HttpSession session;
	
	@Autowired
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	private void visualVehicle(HttpServletRequest request){
		List<VehicleDTO> allVehicle = this.vehicleService.getListaVehicleDTO();
		request.setAttribute("allVehicleDTO", allVehicle);
	}
	
	@RequestMapping(value = "/vehicleManagement", method = RequestMethod.GET)
	public String vehicleManagement(HttpServletRequest request) {
		visualVehicle(request);
		return "/Vehicle/vehicleManager";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idVehicle = Integer.parseInt(request.getParameter("idVehicle"));
		request.setAttribute("idVehicle", idVehicle);
		this.vehicleService.deleteVehicleById(idVehicle);
		visualVehicle(request);
		return "/Vehicle/vehicleManager";
		
	}
	
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idVehicle = Integer.parseInt(request.getParameter("idVehicle"));
		
		VehicleDTO vehicle = vehicleService.getVehicleDTOById(idVehicle);
		
		request.setAttribute("vehicle", vehicle);
		return "/Vehicle/updateVehicle";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualVehicle(request);
		request.setAttribute("option", "insert");
		return "creaVehicle";
		
	}
	
	@RequestMapping(value = "/cercaVehicle", method = RequestMethod.GET)
	public String cercaVehicle(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<VehicleDTO> allVehicle = this.vehicleService.findVehicleDTOByNamevehicle("content");
		request.setAttribute("allVehicleDTO", allVehicle);

		return "/Vehicle/vehicleManager";

	}
	
	@RequestMapping(value = "/creaVehicle", method = RequestMethod.POST)
	public String insertVehicle(HttpServletRequest request) {
	    String namevehicle = request.getParameter("namevehicle").toString();
		String typevehicle = request.getParameter("typevehicle").toString();
		Float speedvehicle = Float.parseFloat(request.getParameter("speedvehicle").toString());
		Float weightvehicle = Float.parseFloat(request.getParameter("weightvehicle").toString());
		Float longvehicle = Float.parseFloat(request.getParameter("longvehicle").toString());
		Float latvehicle = Float.parseFloat(request.getParameter("latvehicle").toString());
		

		VehicleDTO vehicleObj = new VehicleDTO(0,namevehicle, typevehicle, speedvehicle, weightvehicle, longvehicle, latvehicle );
		
		
		vehicleService.insertVehicle(vehicleObj);

		visualVehicle(request);
		return "/Vehicle/vehicleManager";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request)
	{
	Integer idVehicle = Integer.parseInt(request.getParameter("idVehicle"));
		String namevehicleUpdate = request.getParameter("namevehicle");
		String typevehicleUpdate = request.getParameter("typevehicle");
		Float speedvehicleUpdate = Float.parseFloat (request.getParameter("speedvehicle"));
		Float weightvehicleUpdate = Float.parseFloat (request.getParameter("weightvehicle"));
		Float longvehicleUpdate = Float.parseFloat (request.getParameter("longvehicle"));
		Float latvehicleUpdate = Float.parseFloat (request.getParameter("latvehicle"));



		
		final VehicleDTO vehicle = new VehicleDTO(0, namevehicleUpdate,typevehicleUpdate,speedvehicleUpdate, weightvehicleUpdate, longvehicleUpdate, latvehicleUpdate );
		vehicle.setIdVehicle(idVehicle);
		
		vehicleService.updateVehicle(vehicle);
		List<VehicleDTO> list = this.vehicleService.getListaVehicleDTO();
		request.setAttribute("vehicle", list);
		return "/Vehicle/vehicleManager";	
		
	}
	
	}