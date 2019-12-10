package comm.example.controller;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.xdevapi.SessionFactory;

import comm.example.dao.CustomerDao;
import comm.example.dao.CustomerDaoImpl;
import comm.example.factory.HibernateUtilFactory;
import comm.example.model.Customer;

public class AddCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private int id;
	private List<String> errors;
	private CustomerDao dao = null;
	private  org.hibernate.SessionFactory factory = HibernateUtilFactory.getSessionFactory();
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
		errors = new ArrayList<String>();
		String sYear = request.getParameter("id");
		try {
			id=Integer.parseInt(sYear);
			if(id>9000) {
				errors.add("Id out of bounds");
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			errors.add("id must be numeric");
		}
		
	
		name=request.getParameter("name");
		if(name.length()<=8)
			if(name.length()<=8)
		{
			errors.add("invalid Name");
		}
		type=request.getParameter("type");
		if(type.equals("Unknown"))
		{
			errors.add("select a customer type");
		}
		if(!errors.isEmpty())
		{
			request.setAttribute("ERROR", errors);
			RequestDispatcher view=request.getRequestDispatcher("register.view");
			view.forward(request, response);
		}
		else
		{
			Customer c = new Customer(name,id,type);
			request.setAttribute("SUCCESS", c);
			dao = new CustomerDaoImpl();
			dao.createCustomer(c);
			RequestDispatcher view=request.getRequestDispatcher("register.view");
			view.forward(request, response);
		}

	}

}