package com.database;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.model.UserImplementation;

import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static boolean validate(String email, String pass) throws SQLException {
		boolean check = false;
		UserImplementation dao=new UserImplementation();
		check=dao.loginValidate(email, pass);
		return check;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		boolean result=false;
		try {
		result = validate(email, pass);}
		catch(Exception e) {e.printStackTrace();}
		String errorMessage="";
		if (result) {
			HttpSession sus = request.getSession();
			sus.setAttribute("email", email);
			response.sendRedirect("views/dashboard.jsp");
		} else {

			errorMessage = "Incorrect Credentials!";
			request.setAttribute("error", errorMessage);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}

	}

}
