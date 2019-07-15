package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.SignalDTO;
import it.contrader.services.SignalService;

@Controller
@RequestMapping("/Signal")
public class SignalController {
	private final SignalService signalService;
	private httpSession session;
	
	@Autowired
	public SignalController(SignalService signalService) {
		this.signalService = signalService;
	}
	private void visualSignal(HttpServletRequest request) {
		List<SignalDTO> allSignal = this.signalService.getListaSignalDTO();
	}
	@RequestMapping(value = "/signalManagement", method = RequestMethod.GET)
	public String signalManagement(httpServletRequest request) {
		visualSignal(request);
		return "homeSignal";
	}
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idSignal = Integer.parseInt(request.getParameter("idSignal"));
		request.setAttribute("idSignal", idSignal);
		this.signalService.deleteSignalByIdSignal(idSignal);
		visualSignal(request);
		return "homesignal";
	}
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualSignal(request);
		request.setAttribute("option", "insert");
		return "creaSignal";
		
	}
	
	@RequestMapping(value = "/cercaSignal", method = RequestMethod.GET)
	public String cercaSignal(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<SignalDTO> allSignal = this.signalService.findVehicleDTOByTypeVehicle(content);
		request.setAttribute("allSignalDTO", allSignal);

		return "homeSignal";

	}
	
	@RequestMapping(value = "/creaSignal", method = RequestMethod.POST)
	public String insertSignal(HttpServletRequest request) {
		String signalType = request.getParameter("signalType").toString();
		SignalDTO signalObj = new SignalDTO(0, signalType);
		
		signalService.insertSignal(signalObj);

		visualSignal(request);
		return "homeSignal";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String signalType = request.getParameter("signalType");
		final SignalDTO signalDTO = signalService.getBySignalType(signalType);
		
		return "index";	
		
	}	
}

