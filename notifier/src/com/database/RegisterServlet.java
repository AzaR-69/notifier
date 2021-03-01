package com.database;

import java.io.IOException;
import java.sql.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("userName");
		String no = request.getParameter("number");
		String email = request.getParameter("email");
		String pass = request.getParameter("pass1");
		String passCheck = request.getParameter("pass2");
		String url = "jdbc:mysql://localhost:3306/notifier";
		String sql = "INSERT INTO notifier.register (userName,phoneNumber,email,password) VALUES (?,?,?,?)";
		Connection con = null;
		PreparedStatement ps = null;
		String msg = "";
		RequestDispatcher rd = null;
		if (!(pass.equals(passCheck))) {
			msg = "Both passwords must be same!";
			request.setAttribute("message", msg);
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			// response.sendRedirect("signuperror.jsp");
		}
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			con = DriverManager.getConnection(url, "root", "root");
			ps = con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, no);
			ps.setString(3, email);
			ps.setString(4, pass);
			int n = ps.executeUpdate();
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
