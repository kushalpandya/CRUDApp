package org.crudapp.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crudapp.DatabaseManager;
import org.crudapp.entity.CRUDAppUser;

/**
 * Servlet implementation class InsertUserServlet
 */
@WebServlet("/InsertUserServlet")
public class InsertUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean status;
		
		PrintWriter out = response.getWriter();
		CRUDAppUser user = new CRUDAppUser();
		user.setFname(request.getParameter("txtFname"));
		user.setLname(request.getParameter("txtLname"));
		user.setAge(request.getParameter("txtAge"));
		user.setEmail(request.getParameter("txtEmail"));
		user.setCity(request.getParameter("txtCity"));
		
		DatabaseManager db = new DatabaseManager();
		
		try
		{
			db.connect();
			db.insertUser(user);
			db.disconnect();
			status = true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = false;
		}
		
		if(status)
		{
			request.setAttribute("status", "Done");
		}
		else
		
		request.setAttribute("status", "Fail");
		RequestDispatcher rd = request.getRequestDispatcher("InsertDone.jsp");
		rd.forward(request, response);
		//out.println("<h2>Record Was Inserted!</h2>");
	}

}
