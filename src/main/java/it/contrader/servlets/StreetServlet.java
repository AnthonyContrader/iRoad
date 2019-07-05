package it.contrader.servlets;



import java.util.List;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.contrader.dto.StreetDTO;
import it.contrader.service.Service;
import it.contrader.service.StreetService;


public class StreetServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
	
	
	public StreetServlet () {
		
	}
	
	public void updatelist(HttpServletRequest request) {
		
	 Service<StreetDTO> service = new StreetService();
	 List<StreetDTO>listDTO = service.getAll();
	 request.setAttribute("list",listDTO);
	 
	}
	
    @Override
    public void service (HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
    	Service<StreetDTO> service = new StreetService();
    	String mode = request.getParameter("mode");
    	StreetDTO dto;
    	int idstreet;
    	boolean ans;
    	
    	
    	switch(mode.toUpperCase()) {
    	
    	case "STREETLIST":
    		 updatelist(request);
    		 getServletContext().getRequestDispatcher("/street/streetmanager.jsp").forward(request,response);
    		 break;
    		 
    	case "READ":
    		idstreet = Integer.parseInt(request.getParameter("idstreet"));
    		dto = service.read(idstreet);
    		request.setAttribute("dto", dto);
    		
    		if (request.getParameter("update") == null) {
    			getServletContext().getRequestDispatcher("/street/readstreet.jsp").forward(request, response);
    		}
    	   
    		else getServletContext().getRequestDispatcher("/street/updatestreet.jsp").forward(request, response);
    		
    		break;
    		
    	case "INSERT" :
    		String streetname = request.getParameter("streetname").toString();
    		String streettype = request.getParameter("streettype").toString();
    		dto = new StreetDTO (streetname, streettype);
    		ans = service.insert(dto);
    		request.setAttribute("ans", ans);
    		updatelist(request);
    		getServletContext().getRequestDispatcher("/street/streetmanager.jsp").forward(request, response);
    		break;
    		
    	case "UPDATE" :
    		
    		 streetname = request.getParameter("streetname");
     		 streettype = request.getParameter("streettype");
     		 idstreet = Integer.parseInt(request.getParameter("idstreet"));
     		 dto = new StreetDTO ( idstreet, streetname, streettype);
     		 ans = service.update(dto);
     		 updatelist(request);
     		 getServletContext().getRequestDispatcher("street/streetmanager.jsp").forward(request, response);
     		 break;
    	case "DELETE":
        	
    		idstreet = Integer.parseInt(request.getParameter("idstreet"));
    		ans = service.delete(idstreet);
    		request.setAttribute("ans", ans);
    		updatelist(request);
    		getServletContext().getRequestDispatcher("/street/streetmanager.jsp").forward(request, response);
    		break;
    		
    	
    	}
    	
    	
    	
    }
	
	
	
}
