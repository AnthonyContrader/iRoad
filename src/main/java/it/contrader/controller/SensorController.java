package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.SensorDTO;
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
		return "/Sensor/sensorManager";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idSensor = Integer.parseInt(request.getParameter("idSensor"));
		request.setAttribute("idSensor", idSensor);
		this.sensorService.deleteSensorById(idSensor);
		visualSensor(request);
		return "/Sensor/sensorManager";
		
	}
	
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idSensor = Integer.parseInt(request.getParameter("idSensor"));
		
		SensorDTO sensor = sensorService.getSensorDTOById(idSensor);
		
		request.setAttribute("sensor", sensor);
		return "/Sensor/updateSensor";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualSensor(request);
		request.setAttribute("option", "insert");
		return "creaSensor";
		
	}
	
	@RequestMapping(value = "/cercaSensor", method = RequestMethod.GET)
	public String cercaSensor(HttpServletRequest request) {

		final int content = Integer.parseInt(request.getParameter("search"));

		List<SensorDTO> allSensor = this.sensorService.findSensorDTOByIdSensor(content);
		request.setAttribute("allSensorDTO", allSensor);

		return "/Sensor/sensorManager";

	}
	
	@RequestMapping(value = "/creaSensor", method = RequestMethod.POST)
	public String insertSensor(HttpServletRequest request) {
		Float longSensor = Float.parseFloat(request.getParameter("longSensor").toString());		
		Float latSensor = Float.parseFloat(request.getParameter("latSensor").toString());
		String sensorType = request.getParameter("sensorType").toString();
		

		SensorDTO sensorObj = new SensorDTO(0, longSensor, latSensor, sensorType);
		
		sensorService.insertSensor(sensorObj);

		visualSensor(request);
		return "/Sensor/sensorManager";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request)
	{
		int idSensor = Integer.parseInt(request.getParameter("idSensor"));
		Float longSensorUpdate = Float.parseFloat(request.getParameter("longSensor"));
		Float latSensorUpdate = Float.parseFloat(request.getParameter("latSensor"));
		String sensorTypeUpdate = request.getParameter("sensorType");
		
		final SensorDTO sensor = new SensorDTO(0, longSensorUpdate, latSensorUpdate, sensorTypeUpdate );
		sensor.setIdSensor(idSensor);
	
		sensorService.updateSensor(sensor);
		List<SensorDTO> list = this.sensorService.getListaSensorDTO();
		request.setAttribute("sensor", list);
		return "/Sensor/sensorManager";	
		
	}
	
}
