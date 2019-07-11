package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.ScreenDTO;
import it.contrader.services.ScreenService;

import java.util.List;


@Controller
@RequestMapping("/Screen")
public class ScreenController {
	@Autowired
	private ScreenService screenService;
	private HttpSession session;
	
	
	private void visualScreen(HttpServletRequest request){
		List<ScreenDTO> allScreen = this.screenService.getListaScreenDTO();
		request.setAttribute("allScreenDTO", allScreen);
	}
	
	@RequestMapping(value = "/screenManagement", method = RequestMethod.GET)
	public String screenManagement(HttpServletRequest request) {
		visualScreen(request);
		return "homeScreen";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idScreen = Integer.parseInt(request.getParameter("idScreen"));
		request.setAttribute("idScreen", idScreen);
		this.screenService.deleteScreenByIdScreen(idScreen);
		visualScreen(request);
		return "homeScreen";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualScreen(request);
		request.setAttribute("option", "insert");
		return "creaScreen";
		
	}
	
	@RequestMapping(value = "/cercaScreen", method = RequestMethod.GET)
	public String cercaScreen(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<ScreenDTO> allScreen = this.screenService.findScreenDTOByOutput(content);
		request.setAttribute("allScreenDTO", allScreen);

		return "homeScreen";

	}
	
	@RequestMapping(value = "/creaScreen", method = RequestMethod.POST)
	public String insertScreen(HttpServletRequest request) {
		String output = request.getParameter("output").toString();
		ScreenDTO screenObj = new ScreenDTO(0, output);
		
		screenService.insertScreen(screenObj);

		visualScreen(request);
		return "homeScreen";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String output = request.getParameter("output");
		final ScreenDTO screenDTO = screenService.getByOutput(output);
		return "index";
	}
}
