package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;
import com.hsbs.model.beans.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = (UserService) UserFactory.getInstance("service");
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setPassword(request.getParameter("pass"));
		user.setPhone(Integer.parseInt(request.getParameter("phone")));
		user.setDob(request.getParameter("dob"));
		userService.store(user);
		RequestDispatcher rd = request.getRequestDispatcher("login.html");
		rd.forward(request, response);
}
	

}
