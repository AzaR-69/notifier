package com.database;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.editdatabase.model.EditDatabase;

@WebServlet("/EditData")
public class EditData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option=request.getParameter("option");
		String oldName=request.getParameter("oldname");
		String name=request.getParameter("name");
		HttpSession session=request.getSession();
		String email=(String)session.getAttribute("email");
		int row=0;
		try {
			EditDatabase ed=new EditDatabase();
			if(option.equalsIgnoreCase("notebook")) {
				row=ed.editNotebook(name, oldName, email);
				if(row>0) {
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
				row=ed.editNote(name, oldName, email);
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
