package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;
import it.contrader.dto.SensorDTO;
import it.contrader.services.SensorService;
@Controller
@RequestMapping("/Admin")
public class AdminController {
	@Autowired
	private  UserService userService;
	@Autowired
	private  SensorService sensorService;

	
	
	private void visualUser(HttpServletRequest request){

		List<UserDTO> allUser = this.userService.getListaUserDTO();

		request.setAttribute("allUserDTO", allUser);

	}

	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
		return "/User/userManager";

	}
	
	@RequestMapping(value = "/sensorManagement", method = RequestMethod.GET)
	public String sensorManagement(HttpServletRequest request) {
		List<SensorDTO> allSensor = this.sensorService.getListaSensorDTO();
		request.setAttribute("allSensorDTO", allSensor);
		return "/Sensor/sensorManager";

	}

	@RequestMapping(value = "/creaUser", method = RequestMethod.POST)

	public String insertUser(HttpServletRequest request) {

		String username = request.getParameter("username").toString();

		String password = request.getParameter("password").toString();

		String usertype = request.getParameter("usertype").toString();



		UserDTO userObj = new UserDTO(0, username, password, usertype);

		

		userService.insertUser(userObj);



		visualUser(request);

		return "homeAdmin";

	}
	
	
	
	

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	@RequestMapping(value = "/indietro", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		return "homeAdmin";

	}
}