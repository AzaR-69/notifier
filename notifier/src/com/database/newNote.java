package com.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notes.model.Note;
import com.notes.model.NoteImplementation;

/**
 * Servlet implementation class newNote
 */
@WebServlet("/newNote")
public class newNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	private static NoteImplementation dao=new NoteImplementation();
    public newNote() {
        super();
        // TODO Auto-generated constructor stub
    }
    public static boolean countCheck(String notename) throws SQLException {
    	boolean check=false;
    	check=dao.countCheck(notename);
		return check;
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		String mail=(String)session.getAttribute("email");
		String nbName=request.getParameter("notebookName");
		String notename=request.getParameter("notename");
		String sdate=request.getParameter("sdate");
		String edate=request.getParameter("edate");
		String rdate=request.getParameter("rdate");
		String status=request.getParameter("status");
		String tag=request.getParameter("tag");
		String desc=request.getParameter("desc");
		Note note=new Note(mail,nbName,notename,sdate,edate,rdate,status,tag,desc);
		PrintWriter out=response.getWriter();
		int n=0;
		try {
			n=dao.addNote(note);
			boolean result=countCheck(nbName);
			if(n>0) {
				if(result) {
					dao.updateCount(nbName,mail);
				}
				response.sendRedirect("views/dashboard.jsp");
			}
		}
		catch(Exception e) {
			out.println(e);
		}
	}

}
