<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page isELIgnored="false" %>
  <%@ page import="comm.example.model.Customer"%>
  <%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
  <h2>CRM-Customer Relationship Management</h2>
  <br/>
  <br/>
  <a href="list.do">Main</a>

  <br/>
 <a href="addCustomer.jsp" class="btn btn-success">Add Todo</a> 
  <hr/>
<br/>
  <br/>
  <hr/>
 <form action="search.do">
<input type="text" class="form-control" id="search" name="search">
<br/>
 <button type="submit" class="btn btn-dark">Search</button>
 </form>
 <br/>
  <br/>




  <table class="table table-striped">
    <thead>
      <tr>
        <th>Todo</th>
        
      </tr>
    </thead>
    <tbody>
     <c:forEach var="todos" items="${customers}">
     <tr>
       
     <td>${todos.title}</td>
    
    <td><a class="btn btn-danger"href="delete.do?id=<c:out value="${todos.id}"/>">Delete</a> </td>
     <td><a class="btn btn-info"href="editCustomer.jsp?id=<c:out value="${todos.id}"/>">Edit</a> </td>
     </tr>
     
     
     </c:forEach>
     
    </tbody>
  </table>

</div>

</body>
</html>
