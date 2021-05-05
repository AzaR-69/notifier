package com.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notebook.model.Notebook;
import com.notebook.model.NotebookImplementation;

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
		HttpSession session=request.getSession();
		String mail=(String)session.getAttribute("email");
		String noteName=request.getParameter("nbname");
		PrintWriter out=response.getWriter();
		try{
			NotebookImplementation dao=new NotebookImplementation();
			int n=dao.addNotebook(new Notebook(mail,noteName));
    		if(n>0) {
    			response.sendRedirect("views/notebook.jsp");
    		}
    		
		}
		catch(Exception e) {
			out.println(e);
		
		}
	}
}
		
