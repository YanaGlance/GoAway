package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.model.Client;

@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request,
						 HttpServletResponse response)
			throws ServletException, IOException {

		Client client = new Client();
		client.setName(request.getParameter("name"));
		client.setSurname(request.getParameter("surname"));
		
		HttpSession session = request.getSession();
		session.setAttribute(SessionKey.client, client);
		
		response.sendRedirect("addTour.html");
		
	}
}
