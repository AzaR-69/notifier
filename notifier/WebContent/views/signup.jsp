<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sign Up Page</title>
        <link rel="stylesheet" type="text/css" href="./assets/style.css">
    </head>
    <body>
    <%
    	String msg=(String)request.getAttribute("message");
    %>
        <div class="login">
            <h2>Sign Up</h2>
            <%if(msg!=null){ %>
            <h2 style="color: red;"><%=msg %></h2><%} %>
            <form action="../RegisterServlet" method="post">
                <input type="text" name="userName" placeholder="Username" required/><br>
                <input type="text" name="number" placeholder="Mobile Number" required/><br>
                <input type="email" name="email" placeholder="Email" required/><br>
                <input type="password" name="pass1" placeholder="Password" required/><br>
                <input type="password" name="pass2" placeholder="Confirm Password" required/><br>
                <button type="submit">Submit</button>
            </form>
            <p>Already a member? <a href="../index.jsp">Click here</a></p>
        </div>
    </body>        
</html>