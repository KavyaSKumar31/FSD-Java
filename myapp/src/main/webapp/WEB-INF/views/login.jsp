
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
   <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Login</title>
        </head>
        <body>
           <form class="text-center border border-light p-5" method="post" action="/loginProcess">
    <p class="h4 mb-4">Login Form</p>

    <div class="form-row mb-4">
        <div class="col">
            <!-- Username -->
            <input name="username" type="text" class="form-control mb-3" placeholder="User Name"/>
        </div>
        <!-- Password -->
    	<input name="password" type="password" class="form-control mb-3" placeholder="Password"/>
         <!-- Submit button -->
    	<button class="btn btn-info my-4 btn-block" type="submit">Submit</button>
    </div>
</form>
            <table align="center">
                <tr>
                    <td style="font-style: italic; color: red;">${errorMessage}</td>
                </tr>
            </table>
        </body>
        </html>