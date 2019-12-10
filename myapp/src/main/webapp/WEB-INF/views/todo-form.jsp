
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Add</title>
        </head>
        <body>
            <form:form id="todoForm" modelAttribute="todo" action="addTodo" method="post">
                <table align="center">
                    <tr>
                        <td>
                            <form:label path="user">Author: </form:label>
                        </td>
                        <td>
                            <form:input path="user" name="user" id="user" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <form:label path="description">Description:</form:label>
                        </td>
                        <td>
                            <form:input path="description" name="description" id="description" />
                        </td>
                    </tr>
                    
                    <tr>
                        <td></td>
                        <td align="left">
                            <form:button id="save" name="save">Save</form:button>
                        </td>
                    </tr>
                    <tr></tr>
                    
                </table>
            </form:form>
            
        </body>
        </html>