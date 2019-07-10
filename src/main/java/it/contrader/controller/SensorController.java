package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.SensorDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.SensorService;

import java.util.List;


@Controller
@RequestMapping("/Sensor")
public class SensorController {

	private final SensorService sensorService;
	private HttpSession session;
	
	@Autowired
	public SensorController(SensorService sensorService) {
		this.sensorService = sensorService;
	}

	private void visualSensor(HttpServletRequest request){
		List<SensorDTO> allSensor = this.sensorService.getListaSensorDTO();
		request.setAttribute("allSensorDTO", allSensor);
	}
	
	@RequestMapping(value = "/sensorManagement", method = RequestMethod.GET)
	public String sensorManagement(HttpServletRequest request) {
		visualSensor(request);
		return "homeSensor";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idSensor = Integer.parseInt(request.getParameter("idSensor"));
		request.setAttribute("idSensor", idSensor);
		this.sensorService.deleteSensorById(idSensor);
		visualSensor(request);
		return "homeSensor";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualSensor(request);
		request.setAttribute("option", "insert");
		return "creaSensor";
		
	}
	
	@RequestMapping(value = "/cercaSensor", method = RequestMethod.GET)
	public String cercaSensor(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<SensorDTO> allSensor = this.sensorService.findSensorDTOBySensorType(content);
		request.setAttribute("allSensorDTO", allSensor);

		return "homeSensor";

	}
	
	@RequestMapping(value = "/creaSensor", method = RequestMethod.POST)
	public String insertSensor(HttpServletRequest request) {
		String sensorPosition = request.getParameter("sensorPosition").toString();
		String sensorType = request.getParameter("sensorType").toString();

		SensorDTO sensorObj = new SensorDTO(0, sensorPosition, sensorType);
		
		sensorService.insertSensor(sensorObj);
	
		visualSensor(request);
		return "homeSensor";
	}
		
		
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String sensorPosition = request.getParameter("sensorPosition");
		final String sensorType = request.getParameter("sensorType");
		final SensorDTO sensorDTO = sensorService.getBySensorPositionAndSensorType(sensorPosition, sensorType);
		
		return "index";
	}
}
