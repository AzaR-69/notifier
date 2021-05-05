package com.database;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.model.User;
import com.database.model.UserImplementation;


@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserImplementation dao=new UserImplementation();
		User user=new User();
		String userName=request.getParameter("userName");
		String phoneNumber=request.getParameter("number");
		String email=request.getParameter("email");
		String password=request.getParameter("pass");
		String newPassword=request.getParameter("newPass");
		user.setEmail(email);
		user.setPassword(password);
		user.setPhoneNumber(phoneNumber);
		user.setUserName(userName);
		try {
			int row=dao.update(user, newPassword);
			if(row>0) {
				response.sendRedirect("views/dashboard.jsp");
			}
			else {
				String msg="Incorrect email/password";
				request.setAttribute("message", msg);
				RequestDispatcher rd=request.getRequestDispatcher("views/message.jsp");
				rd.forward(request, response);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
