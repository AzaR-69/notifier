package com.database;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.notebook.model.NotebookImplementation;
import com.notes.model.NoteImplementation;

import java.sql.*;

@WebServlet("/DeleteNote")
public class DeleteNote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static NoteImplementation noi = new NoteImplementation();
	private static NotebookImplementation notebooki = new NotebookImplementation();

	public static boolean countCheck(String notename) throws SQLException {
		boolean check = false;
		check = noi.countCheck(notename);
		return check;
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String noteName = request.getParameter("noteName");
		HttpSession session = request.getSession();
		String email = (String) session.getAttribute("email");
		try {
			String notebookName = notebooki.getNotebook(noteName, email);
			int row = noi.deleteNote(noteName, email);
			boolean result = countCheck(notebookName);
			if (row > 0) {
				if (result) {
					noi.updateCount(notebookName, email);
				}
				response.sendRedirect("views/dashboard.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
