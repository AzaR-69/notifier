package com.database;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 * Servlet implementation class editUser
 */
@WebServlet("/editUser")
public class editUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editUser() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement ps=null;
		String uname=request.getParameter("userName");
		String no=request.getParameter("number");
		String mail=request.getParameter("email");
		String pass=request.getParameter("pass");
		String newPass=request.getParameter("newPass");
		String url="jdbc:mysql://localhost:3306/notifier?allowPublicKeyRetrieval=true&useSSL=false";
		String user="root";
		String sql="UPDATE register set userName=?,phoneNumber=?,password=? WHERE email=? AND password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,"root");
			ps=con.prepareStatement(sql);
			ps.setString(1,uname);
			ps.setString(2, no);
			ps.setNString(3, newPass);
			ps.setString(4, mail);
			ps.setString(5, pass);
			int row=ps.executeUpdate();
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
