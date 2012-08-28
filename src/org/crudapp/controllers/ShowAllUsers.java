package org.crudapp.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.crudapp.DatabaseManager;
import org.crudapp.entity.CRUDAppUser;

/**
 * Servlet implementation class ShowAllUsers
 */
@WebServlet("/ShowAllUsers")
public class ShowAllUsers extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowAllUsers() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DatabaseManager dm = new DatabaseManager();
		ArrayList<CRUDAppUser> users = null;
		String status = "";
		try
		{
			dm.connect();
			users = dm.selectUsers();
			dm.disconnect();
			status = "success";
		}
		catch(Exception e)
		{
			e.printStackTrace();
			status = "fail";
		}
		
		request.setAttribute("status", status);
		request.setAttribute("users", users);
		System.out.println(users);
		RequestDispatcher rd = request.getRequestDispatcher("ShowAll.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
