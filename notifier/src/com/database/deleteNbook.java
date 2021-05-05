package com.database;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notebook.model.NotebookImplementation;

@WebServlet("/deleteNbook")
public class deleteNbook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static NotebookImplementation nbi = new NotebookImplementation();

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String notebookName = request.getParameter("notebookName");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		try {
			int row = nbi.deleteNotebook(notebookName, email);
			if (row > 0) {
				nbi.deleteNotes(notebookName, email);
				response.sendRedirect("views/notebook.jsp");
			} else {
				PrintWriter out = response.getWriter();
				out.println("Incorrect notebook name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
