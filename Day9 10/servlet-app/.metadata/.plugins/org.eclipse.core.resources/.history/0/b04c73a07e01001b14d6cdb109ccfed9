package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstname = request.getParameter("fn");
		String lastname = request.getParameter("ln");
		PrintWriter pw = response.getWriter();
		// session object
		HttpSession session = request.getSession();
		// storing data in a session
		session.setAttribute("key1", firstname);
		session.setAttribute("key2", lastname);
		pw.print("<html><body>");
		pw.print("<p>Session Id: "+session.getId()+"</p>");
		pw.print("<p>First Name: "+firstname+", Last Name: "+lastname+"</p>");
		pw.print("</body></html>");
		RequestDispatcher rd = request.getRequestDispatcher("contact.html");
		rd.include(request, response);
	}

}
