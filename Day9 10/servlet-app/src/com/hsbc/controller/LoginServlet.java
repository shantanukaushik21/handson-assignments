package com.hsbc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet is called");
		PrintWriter pw = resp.getWriter();
		pw.print("<html><body><p>");
		pw.print("Login Servlet GET method");
		pw.print("</p></body></html>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doPost is called");
		PrintWriter pw = resp.getWriter();
		// getParameter takes name of the parameter & returns the value in string format
		String username = req.getParameter("user");
		String password = req.getParameter("pass");
		pw.print("<html><body><p>");
		// this is manually verifying the username & password which is done in the model layer
		if(username.equals("Alex") && password.equals("alex123")) {
			pw.print("Hello "+username+", you have logged in");
		} else {
			pw.print("Sorry invalid credentials");
		}
		pw.print("</p></body></html>");
	}
	
}
