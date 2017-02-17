<%@page import="java.util.List"%>
<%@page import="domain.model.Client"%>
<%@page import="domain.model.Tour"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Client client = (Client) session.getAttribute("client");
		Tour tour = (Tour) session.getAttribute("tour");
	%>
	<h1>Twoje dane:</h1>
	<h3><%=client.getName()%></h3>
	<h3><%=client.getSurname()%></h3>
	<h1>Twoja podróż:</h1>
	<h3><%=tour.getCountryTo()%></h3>
	<h3><%=tour.getAmountOfDays()%></h3>
        
     <form action="dbServlet" method="get">
     <input type="submit" value="Dodaj">
         
	</form>
</body>
</html>