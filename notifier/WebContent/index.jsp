	<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login Page</title>
        <link rel="stylesheet" type="text/css" href="views/assets/style.css">
    </head>
    <body>
    	<%String msg=(String)request.getAttribute("message");%>
        <div class="login">
            <h2>Remind Me</h2>
            <h3>Login</h3>
            <%if(msg!=null){ %>
            <h2 style="color: green;"><%=msg %></h2><%} %>
            <form action="LoginServlet" method="post">
                <input type="email" name="email" placeholder="Email" required/><br>
                <input type="password" name="pass" placeholder="Password" required/><br>
                <button type="submit">Login</button>
            </form>
            <p>Not a member? <a href="views/signup.jsp">Sign Up</a></p>
        </div>
    </body>        
</html>