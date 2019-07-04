package it.contrader.servlets;

import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.ScreenDTO;
import it.contrader.service.Service;
import it.contrader.service.ScreenService;

public class ScreenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ScreenServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ScreenDTO> service = new ScreenService();
		List<ScreenDTO>listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ScreenDTO> service = new ScreenService();
		String mode = request.getParameter("mode");
		ScreenDTO dto;
		int idScreen;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "SCREENLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/screen/screenmanager.jsp").forward(request, response);
			break;

		case "READ":
			idScreen = Integer.parseInt(request.getParameter("idScreen"));
			dto = service.read(idScreen);
			request.setAttribute("dto", dto);
			
			if (request.getParameter("update") == null) {
				 getServletContext().getRequestDispatcher("/screen/readscreen.jsp").forward(request, response);
				
			}
			
			else getServletContext().getRequestDispatcher("/screen/updatescreen.jsp").forward(request, response);
			
			break;

		case "INSERT":
			String output = request.getParameter("output").toString();
			dto = new ScreenDTO (output);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/user/usermanager.jsp").forward(request, response);
			break;
			
		case "UPDATE":
			output = request.getParameter("output");
			idScreen = Integer.parseInt(request.getParameter("idScreen"));
			dto = new ScreenDTO (idScreen,output);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/screen/screenmanager.jsp").forward(request, response);
			break;

		case "DELETE":
			idScreen = Integer.parseInt(request.getParameter("idScreen"));
			ans = service.delete(idScreen);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/screen/screenmanager.jsp").forward(request, response);
			break;
		}
	}
}