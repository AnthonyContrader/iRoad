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
		return "homeVehicle";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idVehicle = Integer.parseInt(request.getParameter("idVehicle"));
		request.setAttribute("idVehicle", idVehicle);
		this.vehicleService.deleteVehicleById(idVehicle);
		visualVehicle(request);
		return "homeVehicle";
		
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

		List<VehicleDTO> allVehicle = this.vehicleService.findVehicleDTOByTypeVehicle(content);
		request.setAttribute("allVehicleDTO", allVehicle);

		return "homeVehicle";

	}
	
	@RequestMapping(value = "/creaVehicle", method = RequestMethod.POST)
	public String insertVehicle(HttpServletRequest request) {
		String nameVehicle = request.getParameter("nameVehicle").toString();
		String typeVehicle = request.getParameter("typeVehicle").toString();
		Double speedVehilce = Double.parseDouble(request.getParameter("speedVehicle").toString());
		Double weightVehilce = Double.parseDouble(request.getParameter("weightVehicle").toString());
		Double longVehilce = Double.parseDouble(request.getParameter("longVehicle").toString());
		Double latVehilce = Double.parseDouble(request.getParameter("latVehicle").toString());

		VehicleDTO vehicleObj = new VehicleDTO(0, nameVehicle, typeVehicle, speedVehilce,weightVehilce,longVehilce,latVehilce);
		
		vehicleService.insertVehicle(vehicleObj);

		visualVehicle(request);
		return "homeVehicle";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String nameVehicle = request.getParameter("nameVehicle");
		final String typeVehicle = request.getParameter("typeVehicle");
		final VehicleDTO vehicleDTO = vehicleService.getByNameVehicleAndTypeVehicle(nameVehicle, typeVehicle);
		
		return "index";	
		
	}
	
}
