package web.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.sessionKey;
import domain.model.Client;

@WebFilter(urlPatterns = {"/addTour.html","/final", "/tourServlet","/tourServlet"})

public class ClientFilter implements Filter {

	 public ClientFilter() {
		 }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Client client = (Client) session.getAttribute(sessionKey.client);
		if(client==null){
			((HttpServletResponse) response).sendRedirect("/addClient.html");
		}
		else{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
