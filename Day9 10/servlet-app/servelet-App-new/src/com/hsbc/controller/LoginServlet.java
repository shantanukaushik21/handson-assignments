package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet is called");
		PrintWriter pw = response.getWriter();
		pw.print("<html><body><p>");
		pw.print("Login Servlet GET method");
		pw.print("</p></body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost is called");
		PrintWriter pw = response.getWriter();
		// getParameter takes name of the parameter & returns the value in string format
		String username = request.getParameter("user");
		String password = request.getParameter("pass");
		
		if(username.equals("Alex") && password.equals("alex123")) {
			RequestDispatcher rd = request.getRequestDispatcher("success.html");
			pw.print("<html><body><p>");
			pw.print("Using Forward");
			pw.print("</p></body></html>");
			rd.forward(request, response);
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			pw.print("<html><body>");
			pw.print("<p style = 'color:red'>Sorry Invalid Credentials, Please login again</p>");
			pw.print("</body></html>");
			rd.include(request, response);
		}
		
//		pw.print("<html><body><p>");
//		// this is manually verifying the username & password which is done in the model layer
//		if(username.equals("Alex") && password.equals("alex123")) {
//			pw.print("Hello "+username+", you have logged in");
//		} else {
//			pw.print("Sorry invalid credentials");
//		}
//		pw.print("</p></body></html>");
	}

}
