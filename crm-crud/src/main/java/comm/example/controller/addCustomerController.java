package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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


@WebServlet("/add.do")
public class addCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	
	private List<String> errors = null; 
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		//Accessing Value Inserted From AddLeague.jsp Form
		
		errors = new ArrayList<String>(); //create an instance of list
		title = request.getParameter("title").toString();
		if((title == null) || (title.length() < 5)) {
			errors.add("first name should have Atleast 5 characters");
		}
		
		
		
		
		
		if(!errors.isEmpty()) {
			request.setAttribute("ERRORS", errors);
			RequestDispatcher view = request.getRequestDispatcher("addCustomer.jsp");
			view.forward(request, response);
		}
		else {
			Customer details = new Customer(title);
			CustomerDAO dao = new CustomerDAOImpl();
			request.setAttribute("SUCCESS", details);
			dao.createTodo(details);
			RequestDispatcher view = request.getRequestDispatcher("list.do");
			view.forward(request, response);
		}
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

