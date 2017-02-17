package web;

import domain.model.Country;
import domain.model.Reservation;
import domain.model.Client;
import domain.model.Tour;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ReservationServlet")
public class ReservationServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	Reservation reservation = new Reservation();
    	
		reservation.setMeal(request.getParameter("meal"));
		reservation.setRecomendation(request.getParameter("recomendation"));
		
		HttpSession session = request.getSession();
		session.setAttribute(SessionKey.reservation, reservation);
		
		response.sendRedirect("final.jsp");
	}
}
