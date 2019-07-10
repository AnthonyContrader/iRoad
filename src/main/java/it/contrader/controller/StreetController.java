package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.StreetDTO;
import it.contrader.services.StreetService;

import java.util.List;


@Controller
@RequestMapping("/Street")
public class StreetController {

	private final StreetService streetService;
	
	
	@Autowired
	public StreetController(StreetService streetService) {
		this.streetService = streetService;
	}

	private void visualStreet(HttpServletRequest request){
		List<StreetDTO> allStreet = this.streetService.getListaStreetDTO();
		request.setAttribute("allStreetDTO", allStreet);
	}
	
	@RequestMapping(value = "/streetManagement", method = RequestMethod.GET)
	public String streetManagement(HttpServletRequest request) {
		visualStreet(request);
		return "homeStreet";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idStreet = Integer.parseInt(request.getParameter("idStreet"));
		request.setAttribute("idStreet", idStreet);
		this.streetService.deleteStreetById(idStreet);
		visualStreet(request);
		return "homeStreet";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualStreet(request);
		request.setAttribute("option", "insert");
		return "creaStreet";
		
	}
	
	@RequestMapping(value = "/cercaStreet", method = RequestMethod.GET)
	public String cercaStreet(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<StreetDTO> allStreet = this.streetService.findStreetDTOByStreetname(content);
		request.setAttribute("allStreetDTO", allStreet);

		return "homeStreet";

	}
	
	@RequestMapping(value = "/creaStreet", method = RequestMethod.POST)
	public String insertStreet(HttpServletRequest request) {
		String streetName = request.getParameter("streetName").toString();
		String streetType = request.getParameter("streetType").toString();

		StreetDTO streetObj = new StreetDTO(0, streetName, streetType);
		
		streetService.insertStreet(streetObj);
	
		visualStreet(request);
		return "homeStreet";
	}
		
		
	}