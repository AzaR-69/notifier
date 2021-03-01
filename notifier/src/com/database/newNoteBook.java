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
 * Servlet implementation class newNoteBook
 */
@WebServlet("/newNoteBook")
public class newNoteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public newNoteBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		String url="jdbc:mysql://localhost:3306/notifier";
		String user="root";
		String sql="INSERT INTO notifier.notebook_db (email,notebookName) VALUES(?,?)";
		HttpSession session=request.getSession();
		String mail=(String)session.getAttribute("email");
		String noteName=request.getParameter("nbname");
		PrintWriter out=response.getWriter();
		try{
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
    		con=DriverManager.getConnection(url,user,"root");
    		ps=con.prepareStatement(sql);
    		ps.setString(1,mail);
    		ps.setString(2,noteName);
    		int row=ps.executeUpdate();
    		if(row>0) {
    			response.sendRedirect("views/notebook.jsp");
    		}
    		
		}
		catch(Exception e) {
			out.println(e);
		
		}
	}
}
		
