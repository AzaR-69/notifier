package com.database;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

/**
 * Servlet implementation class DeleteNote
 */
@WebServlet("/DeleteNote")
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNote() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static boolean countCheck(String notename) {
    	Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String url="jdbc:mysql://localhost:3306/notifier?allowPublicKeyRetrieval=true&useSSL=false";
		String user="root";
		boolean check=false;
		String sql="SELECT * FROM notebook_db WHERE notebookName=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, "root", "examly");
			ps=con.prepareStatement(sql);
			ps.setNString(1, notename);
			rs=ps.executeQuery();
			check=rs.next();
			
		}
		catch(Exception e) { e.printStackTrace();}
		return check;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection con=null;
		PreparedStatement ps=null;
		String noteName=request.getParameter("noteName");
		String url="jdbc:mysql://localhost:3306/notifier?allowPublicKeyRetrieval=true&useSSL=false";
		String user="root";
		HttpSession session=request.getSession();
		String mail=(String)session.getAttribute("email");
		String sql2="SELECT notebookName FROM newnote WHERE noteName=? AND email=?";
		String sql="DELETE FROM newnote WHERE noteName=? AND email=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, "root", "examly");
			ps=con.prepareStatement(sql2);
			ps.setString(1, noteName);
			ps.setNString(2, mail);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				String nbName=rs.getString("notebookName");
				ps=con.prepareStatement(sql);
				ps.setString(1, noteName);
				ps.setString(2,mail);
				int row=ps.executeUpdate();
				int c=0;
				boolean result=countCheck(nbName);
				if(row>0) {
					if(result) {
						sql="SELECT COUNT(*) from newnote WHERE notebookName=? AND email=?";
						ps=con.prepareStatement(sql);
						ps.setNString(1, nbName);
						ps.setString(2,mail);
						rs=ps.executeQuery();
						if(rs.next()) {
							c=Integer.parseInt(rs.getString(1));
							sql="UPDATE notebook_db SET count=? WHERE notebookName=? AND email=?";
							ps=con.prepareStatement(sql);
							ps.setInt(1, c);
							ps.setNString(2, nbName);
							ps.setString(3,mail);
							ps.executeUpdate();
						}
					}
					response.sendRedirect("views/dashboard.jsp");
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
