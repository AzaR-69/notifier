package com.database;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.database.model.UserImplementation;
import com.database.model.User;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String phoneNumber = request.getParameter("number");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass1");
		String passCheck = request.getParameter("pass2");	
		String msg = "";
		String errorMessage="";
		RequestDispatcher rd=null;
		int n=0;
		if (!(pass.equals(passCheck))) {
			errorMessage = "Both passwords must be same!";
			request.setAttribute("error", errorMessage);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		}
		try {
			UserImplementation dao=new UserImplementation();
			n=dao.add(new User(userName,phoneNumber,email,pass));
			if (n > 0) {
				msg = "Account created successfully!";
				request.setAttribute("message", msg);
				rd = request.getRequestDispatcher("index.jsp");
				rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
