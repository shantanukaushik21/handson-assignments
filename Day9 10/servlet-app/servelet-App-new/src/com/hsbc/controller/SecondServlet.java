package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
		String phone = request.getParameter("ph");
		String email = request.getParameter("email");
		PrintWriter pw = response.getWriter();
		pw.print("<html><body>");
		pw.print("<p>Before Getting From Session, First Name: "+firstname+", Last Name: "+lastname+"</p>");
		HttpSession session = request.getSession(); // it uses the existing session if session created for the client
		firstname = (String)session.getAttribute("key1");
		lastname = (String)session.getAttribute("key2");
		pw.print("<p>Session Id: "+session.getId()+"</p>");
		pw.print("<p>After Getting From Session, First Name: "+firstname+", Last Name: "+lastname+"</p>");
		pw.print("<p>Phone: "+phone+", Email Id: "+email+"</p>");
		
		pw.print("</body></html>");
		
	}

}
