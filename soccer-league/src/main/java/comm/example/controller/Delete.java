package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.CustomerDao;
import comm.example.dao.CustomerDaoImpl;
import comm.example.model.Customer;

/**
 * Servlet implementation class Delete
 */
public class Delete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		CustomerDao dao = new CustomerDaoImpl();
		PrintWriter out=response.getWriter();
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		int t = dao.deleteCustomer(id);
		
		RequestDispatcher view=request.getRequestDispatcher("delete.view");
		view.forward(request, response);
		
				
		

	
}}