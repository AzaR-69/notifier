package com.database;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static boolean validate(String email, String pass) {
		boolean check = false;
		Connection con = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/notifier?allowPublicKeyRetrieval=true&useSSL=false";
		String sql = "SELECT * FROM register WHERE email=? AND password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, "root", "root");
			ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			check = rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		boolean result = validate(email, pass);
		String msg = "";
		if (result) {
			HttpSession sus = request.getSession();
			sus.setAttribute("email", email);
			response.sendRedirect("views/dashboard.jsp");
		} else {

			msg = "Incorrect Credentials!";
			request.setAttribute("message", msg);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			// response.sendRedirect("index.jsp");
		}

	}

}
