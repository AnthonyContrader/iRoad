package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;

import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private HttpSession session;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		visualUser(request);
		return "/User/userManager";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		request.setAttribute("idUser", idUser);
		this.userService.deleteUserById(idUser);
		visualUser(request);
		return "/User/userManager";
		
	}
	
	
	@RequestMapping(value = "/redirectUpdate", method = RequestMethod.GET)
	public String redirectUpdate(HttpServletRequest request) {
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		
		UserDTO user = userService.getUserDTOById(idUser);
		
		request.setAttribute("user", user);
		return "/User/updateUser";
		
	}
	
	@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualUser(request);
		request.setAttribute("option", "insert");
		return "creaUser";
		
	}
	
	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
		request.setAttribute("allUserDTO", allUser);

		return "/User/userManager";

	}
	
	@RequestMapping(value = "/creaUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		String usertype = request.getParameter("usertype").toString();
		

		UserDTO userObj = new UserDTO(0, username, password, usertype);
		
		userService.insertUser(userObj);

		visualUser(request);
		return "/User/userManager";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(HttpServletRequest request)
	{
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		String usernameUpdate = request.getParameter("username");
		String passwordUpdate = request.getParameter("password");
		String usertypeUpdate = request.getParameter("usertype");
		
		final UserDTO user = new UserDTO(0, usernameUpdate,passwordUpdate,usertypeUpdate);
		user.setIdUser(idUser);
		
		userService.updateUser(user);
		List<UserDTO> list = this.userService.getListaUserDTO();
		request.setAttribute("user", list);
		return "/User/userManager";	
		
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String usertype = userDTO.getUsertype();
		if (!StringUtils.isEmpty(usertype)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (usertype.equals("ADMIN")) {
				return "home";
			} else if (usertype.equals("USER")) {
				return "home";
			}
		}
		return "index";
	}
	
	
	
	
	
	
	
	
}
