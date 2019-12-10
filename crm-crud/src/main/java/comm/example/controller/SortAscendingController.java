package comm.example.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.CustomerDAO;
import comm.example.dao.CustomerDAOImpl;
import comm.example.model.Customer;

@WebServlet("/sortasc.do")

public class SortAscendingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Customer> list;
	
	

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		CustomerDAO dao = new CustomerDAOImpl();
		list=dao.sortAsc();
		request.setAttribute("customers", list);
		RequestDispatcher view=request.getRequestDispatcher("list-customers.jsp");
		view.forward(request, response);
	}

}
