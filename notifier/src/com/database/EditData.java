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

/**
 * Servlet implementation class EditData
 */
@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option=request.getParameter("option");
		String old=request.getParameter("oldname");
		String name=request.getParameter("name");
		Connection con=null;
		PreparedStatement ps=null;
		HttpSession session=request.getSession();
		String mail=(String)session.getAttribute("email");
		String sql="";
		String url="jdbc:mysql://localhost:3306/notifier?allowPublicKeyRetrieval=true&useSSL=false";
		String user="root";
		int row=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, "root", "examly");
			if(option.equalsIgnoreCase("notebook")) {
				sql="UPDATE notebook_db SET notebookName=? WHERE notebookName=? AND email=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2,old);
				ps.setNString(3, mail);
				row=ps.executeUpdate();
				if(row>0) {
					sql="UPDATE newnote SET notebookName=? WHERE notebookName=? AND email=?";
					ps=con.prepareStatement(sql);
					ps.setString(1, name);
					ps.setString(2,old);
					ps.setNString(3, mail);
					ps.executeUpdate();
					response.sendRedirect("views/notebook.jsp");
				}
				else {
					String msg="Incorrect option! Please choose the correct option";
					request.setAttribute("message", msg);
					RequestDispatcher rd=request.getRequestDispatcher("views/message.jsp");
					rd.forward(request, response);
				}
			}
			else {
				sql="UPDATE newnote SET noteName=? WHERE noteName=? AND email=?";
				ps=con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2,old);
				ps.setNString(3, mail);
				row=ps.executeUpdate();
				if(row>0) {
					response.sendRedirect("views/dashboard.jsp");
				}
				else {
					String msg="Incorrect option! Please choose the correct option";
					request.setAttribute("message", msg);
					RequestDispatcher rd=request.getRequestDispatcher("views/message.jsp");
					rd.forward(request, response);
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
