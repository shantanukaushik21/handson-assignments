package com.hsbc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hsbc.exception.AuthenticationException;
import com.hsbc.model.service.UserService;
import com.hsbc.model.util.UserFactory;
import com.hsbs.model.beans.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService=(UserService) UserFactory.getInstance("service");
		RequestDispatcher rd = null;
		try {
			User user=userService.login(Integer.parseInt(request.getParameter("userId")), request.getParameter("pass"));
			HttpSession session =request.getSession();
			session.setAttribute("id", user);
			rd=request.getRequestDispatcher("loginSuccess.jsp");
			rd.forward(request, response);
		}catch(AuthenticationException e){
			rd = request.getRequestDispatcher("loginFailure.jsp");
			request.setAttribute("err", e.getMessage());
			rd.forward(request, response);
		} 
	}

}
