package org.crudapp.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crudapp.DatabaseManager;
import org.crudapp.entity.CRUDAppUser;

/**
 * Servlet implementation class ShowByName
 */
@WebServlet("/ShowByName")
public class ShowByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowByName() {
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
		String key = request.getParameter("txtSearch");
		DatabaseManager dm = new DatabaseManager();
		
		CRUDAppUser user = null;
		try
		{
			dm.connect();
			user = dm.searchByName(key);
			dm.disconnect();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(user != null)
		{
			request.setAttribute("status", "success");
			request.setAttribute("fname", user.getFname());
			request.setAttribute("lname", user.getLname());
			request.setAttribute("age", user.getAge());
			request.setAttribute("email", user.getEmail());
			request.setAttribute("city", user.getCity());
		}
		else
			request.setAttribute("status", "notfound");
		
		RequestDispatcher rd = request.getRequestDispatcher("ShowUser.jsp");
		rd.forward(request, response);
	}

}
