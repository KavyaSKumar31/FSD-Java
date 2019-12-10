<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
    <%@ page import="comm.example.model.Customer"%>
    <%@ page import="comm.example.dao.*"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Edit Customer</title>
</head>
<body>
<%
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) request.getAttribute("ERRORS");
		if (list != null) {
			for (String str : list) {
				out.println("<font color='red'>" + str.toUpperCase() + "</font><br/>");
				
			}
		}
		CustomerDAO dao= new CustomerDAOImpl(); 
		String sid =request.getParameter("id");
		int id = Integer.parseInt(sid);
		Customer c = dao.getTodoById(id);
		
		
		
		
	%>
	
<form action="edit.do" method="post">
  <div class="form-group">
    <label for="title">First Name</label>
    <input type="text" class="form-control" id="firstName" name="title" value=<%= c.getTitle()%> >
  </div>
  
  <input type="hidden" id="Id" name="id" value=<%=  request.getParameter("id") %>>
  <button type="submit" class="btn btn-info">Submit</button>
</form>
</body>
</html>