<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="todo" items="${todos}">
				
				
					
									
					
					<tr>
						
						<td> ${todo.user} </td>
						<td> ${todo.description} </td>
						
						
						
						
					</tr>
				
				</c:forEach>
						
			</table>
			<a href="/home">Back to home</a>
</body>
</html>