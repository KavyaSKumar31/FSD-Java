package comm.example.controller;

import java.io.IOException;
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


@WebServlet("/edit.do")
public class editController extends HttpServlet {
	private List<String> errors = null; 
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	private void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		String sid;
		String title;
		
		errors = new ArrayList<String>(); //create an instance of list
		title = request.getParameter("title").toString();
		if((title == null) || (title.length() < 5)) {
			errors.add("title should have Atleast 5 characters");
		}
		
		
		
		
		if(!errors.isEmpty()) {
			request.setAttribute("ERRORS", errors);
			RequestDispatcher view = request.getRequestDispatcher("addCustomer.jsp");
			view.forward(request, response);
		}
		else {
			CustomerDAO dao= new CustomerDAOImpl(); 
			sid = request.getParameter("id").toString();
			title = request.getParameter("title");
			int id = Integer.parseInt(sid);
			Customer c = dao.getTodoById(id);
			c.setTitle(title);
			
			dao.editTodo(c);
			RequestDispatcher view = request.getRequestDispatcher("list.do");
			view.forward(request, response);
		}
		
		
	}
		

}
