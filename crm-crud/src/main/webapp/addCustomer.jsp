<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
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
		
	%>
<form action="add.do" method="post">
  <div class="form-group">
    <label for="title">Title</label>
    <input type="text" class="form-control" id="firstName" name="title">
  </div>
  
  <button type="submit" class="btn btn-info">Submit</button>
</form>
</body>
</html>