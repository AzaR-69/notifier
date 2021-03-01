package com.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class deleteNbook
 */
@WebServlet("/deleteNbook")
public class deleteNbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteNbook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String notebookName=request.getParameter("notebookName");
		Connection con=null;
		PreparedStatement ps=null;
		HttpSession session=request.getSession();
		String mail=(String)session.getAttribute("email");
		String url="jdbc:mysql://localhost:3306/notifier";
		String sql="DELETE FROM notebook_db WHERE notebookName=? AND email=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,"root","root");
			ps=con.prepareStatement(sql);
			ps.setNString(1, notebookName);
			ps.setNString(2, mail);
			int row=ps.executeUpdate();
			if(row>0) {
				sql="DELETE FROM newnote WHERE notebookName=? AND email=?";
				ps=con.prepareStatement(sql);
				ps.setNString(1, notebookName);
				ps.setNString(2, mail);
				ps.executeUpdate();
				response.sendRedirect("views/notebook.jsp");
			}
			else {
				PrintWriter out=response.getWriter();
				out.println("Incorrect notebook name");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
