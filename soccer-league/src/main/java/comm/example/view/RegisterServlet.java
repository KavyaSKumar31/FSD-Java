package comm.example.view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comm.example.dao.CustomerDao;
import comm.example.dao.CustomerDaoImpl;
import comm.example.model.Customer;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<String> l=null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	private String types=null;
	  private String[] typesArr;
	  
		@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		types=config.getInitParameter("type");
		typesArr=types.split(",");
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	@SuppressWarnings("unchecked")
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		l=(List<String>) request.getAttribute("ERROR");
		if(l!=null)
		{
			out.println("please correct the bellow error(s)<br/>");
			for(String str:l)
			{
				out.println("<font color='red'>"+str+"</font><br/>");
			}
		}
		
		out.println("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"UTF-8\">\r\n" + 
				"<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\">\r\n" + 
				"<title>Add</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<!-- Default form login -->\r\n" + 
				"<form class=\"text-center border border-light p-5\" action=\"add_customer.do\" method=\"post\">\r\n" + 
				"\r\n" + 
				"    <p class=\"h4 mb-4\">Input Customer Details.</p>\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    <input type=\"text\" id=\"defaultLoginFormEmail\" class=\"form-control mb-4\" placeholder=\"ID\" name=\"id\">\r\n" + 
				"\r\n" + 
				"    \r\n" + 
				"    <input type=\"text\" id=\"defaultLoginFormPassword\" class=\"form-control mb-4\" placeholder=\"name\" name=\"name\">\r\n" + 
				"\r\n" );
		out.println("<select name='type'>");
		for(String str:typesArr) {
		
			out.println("<option value='"+str+"'>"+str+"</option>");
		}
		out.println("</select>");
		out.println(
				"</select>\r\n" + 
				"\r\n" + 
				"    <!-- Sign in button -->\r\n" + 
				"    <button class=\"btn btn-info btn-block my-4\" type=\"submit\">Add A New Customer</button>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</form>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		
	

	CustomerDao dao = new CustomerDaoImpl();
	List<Customer> c = dao.DisplayCustomer();
	if (!c.isEmpty()) {
	
		out.println("<table class=\"table\">\r\n" + "  <thead>\r\n" + "    <tr>\r\n"
				+ "  <th scope=\"col\">Id</th>\r\n"
				+ "      <th scope=\"col\">Name</th>\r\n" + "      <th scope=\"col\">Type</th>\r\n"
				+ "    </tr>\r\n" + "  </thead>\r\n" + "  <tbody>");
		for (Customer str : c) {
			out.println("<tr>\r\n" + "<td>" + str.getId() + "</td><td>" + str.getName() + "</td><td>"
					+ str.getType() +  "</td><td>"+ "<button type=\"button\" formaction=\"delete\"class=\"btn btn-danger\">Delete</button></td><td>"+"<button type=\"button\" class=\"btn btn-primary\">Edit</button></td></tr>");
		}
	}


}

}

