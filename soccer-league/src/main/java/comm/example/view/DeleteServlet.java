package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.CustomerDao;
import comm.example.dao.CustomerDaoImpl;
import comm.example.model.Customer;

/**
 * Servlet implementation class DeleteServlet
 */
public class DeleteServlet extends HttpServlet {
	
       
	private static final long serialVersionUID = 1L;
	private List<Customer> list=null;
	   
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
			ArrayList<Customer> se=(ArrayList<Customer>) dao.DisplayCustomer();
			
			out.println("<form action='delete' method='post'>");
			out.println("<select name='id'>");
			for(Customer c:se) {
				int id = c.getId();
				String name = c.getName();
				String type = c.getType();
				out.println("<option value='"+id+"'>"+name+" "+type+"<option>");
			}
			out.println("</select>");
			out.println("<button type='submit'>Delete Customer</button>");
			out.println("</form>");
			
			}
}
