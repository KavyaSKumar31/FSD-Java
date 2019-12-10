package comm.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import comm.example.dao.TodoDAO;
import comm.example.dao.TodoDAOImpl;
import comm.example.model.Login;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view=request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	TodoDAO dao1= new TodoDAOImpl() ;
	String hPass = null;
	String uName=request.getParameter("uName");
	String uPass=request.getParameter("uPass");
	if(uName != null) {
	List<Login> l = dao1.getCred(uName);
	for(Login user: l) {
		 hPass =user.getUPass().toString();
		 System.out.println(hPass);
	}
	uPass= uPass.toString();
	hPass= hPass.toString();
	
	if(uPass.equals(hPass))
	{
		System.out.println(uPass);
		HttpSession session=request.getSession(true);
		session.setAttribute("uName", uName);
		RequestDispatcher view=request.getRequestDispatcher("list.do");
		view.forward(request, response);
	}
	else {
		 PrintWriter out = response.getWriter();
	      out.println("Wrong Password");
		RequestDispatcher view=request.getRequestDispatcher("login.jsp");
		view.forward(request, response);
		
	}}
	}

}
