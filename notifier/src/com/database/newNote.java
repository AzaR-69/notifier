package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class newNote
 */
@WebServlet("/newNote")
public class newNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newNote() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement ps=null;
		HttpSession session=request.getSession();
		String url="jdbc:mysql://localhost:3306/notifier?allowPublicKeyRetrieval=true&useSSL=false";
		String user="root";
		String sql="INSERT INTO notifier.newNote (email,notebookName,noteName,startDate,endDate,remainderDate,status,tag,description) VALUES(?,?,?,?,?,?,?,?,?)";
		String mail=(String)session.getAttribute("email");
		String nbName=request.getParameter("notebookName");
		String notename=request.getParameter("notename");
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String rdate=request.getParameter("rdate");
		String status=request.getParameter("status");
		String tag=request.getParameter("tag");
		String descr=request.getParameter("desc");
		PrintWriter out=response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, "root", "examly");
			ps=con.prepareStatement(sql);
			ps.setString(1,mail);
			ps.setNString(2, nbName);
			ps.setNString(3, notename);
			ps.setNString(4, sdate);
			ps.setNString(5, edate);
			ps.setNString(6, rdate);
			ps.setNString(7, status);
			ps.setNString(8, tag);
			ps.setNString(9, descr);
			ResultSet rs=null;
			int row=ps.executeUpdate();
			int c=0;
			boolean result=countCheck(nbName);
			if(row>0) {
				if(result) {
					sql="SELECT COUNT(*) from newnote WHERE notebookName=? AND email=?";
					ps=con.prepareStatement(sql);
					ps.setNString(1, nbName);
					ps.setNString(2, mail);
					rs=ps.executeQuery();
					if(rs.next()) {
						c=Integer.parseInt(rs.getString(1));
						sql="UPDATE notebook_db SET count=? WHERE notebookName=? AND email=?";
						ps=con.prepareStatement(sql);
						ps.setInt(1, c);
						ps.setNString(2, nbName);
						ps.setNString(3, mail);
						ps.executeUpdate();
					}
				}
				response.sendRedirect("views/dashboard.jsp");
			}
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
