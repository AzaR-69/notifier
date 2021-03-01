<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.time.*"%>
    
<!DOCTYPE html>
<html>
    <head>
        <title>Welcome</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="./assets/dashstyle.css" rel="stylesheet">
        <link href="./assets/notification.css" rel="stylesheet">
    </head>
    <body>
    <%
    	response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
		response.setHeader("Pragma","no-cache");
		response.setHeader("Expires","0");
		String mail=(String)session.getAttribute("email");
		String nbName=request.getParameter("notebk");
		if(mail==null){
			response.sendRedirect("index.jsp");
		}
		LocalDate ld=LocalDate.now();
		String currentDate=ld.toString();
		boolean result=false;
		Connection con=null;
		PreparedStatement ps=null;
		PreparedStatement ps2=null;
		String url="jdbc:mysql://localhost:3306/notifier";
		String user="root";
		String sql="SELECT * from newnote WHERE notebookName=? AND email=?";

        try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection(url,user,"root");
		ps=con.prepareStatement(sql);
		ps.setString(1,nbName);
		ps.setString(2,mail);
		ResultSet rs=ps.executeQuery();
		boolean check =rs.next();
   		%>
    
        <nav class="nav-wrapper indigo">
            <div>
                <a href="" class="sidenav-trigger show-on-large" data-target="mobile-menu">
                    <i class="material-icons">menu</i>
                </a>
                <ul class="sidenav" id="mobile-menu">
                	<li><a href=""><i class="fas fa-user-tie"></i> <b>Hi <%=mail%></b></a></li>
                	<li class="divider"></li>
                    <li><a href="notebook.jsp"><i class="fas fa-book-reader"></i>NoteBooks</a></li>
                    <li class="divider"></li>
                    <li><a href="dashboard.jsp"><i class="fas fa-sticky-note"></i>Notes</a></li>
                    <li class="divider"></li>
                    <li><a href="edituser.jsp"><i class="fas fa-user-edit"></i>Edit User</a></li>
                </ul>
                <ul class="right" id="right-bar">
                	<li id="noticlick"><i class="fas fa-bell"></i>&nbsp;Notifications&emsp;</li>
                    <li><a href="notes.jsp?notebk=<%=nbName%>"><i class="fas fa-book-open"></i>&nbsp;New Note</a></li>
                    <li><a href="../logout"><i class="fas fa-sign-out-alt"></i>&nbsp;Logout</a></li>
                  </ul>
            </div>     
        </nav>
         <div id="notification">
                <ul id="alert">
                <%if(!check){ %>
                    <li>&emsp;No notifications</li><% 
                    }else{
                    	rs=ps.executeQuery();
        				while(rs.next()){
                    	String cDate=rs.getString("remainderDate");
						String desc=rs.getString("description"); 
						if(currentDate.equals(cDate)){
							result=true;
                    %>
            		<li><i class="fas fa-exclamation"></i>&emsp;<%=desc %> </li>
                	<%}}if(!result){%>
        			<li>&emsp;No notifications</li>	
        			<%}} %>
                </ul>       
        </div>
        
              <h4 style="margin-left:25px">Daily Tasks</h4>
              
        <%
    		if(!check){%>
			<h5 style="text-align:center">No note is created</h5>
			<h6 style="text-align:center"><a href="notes.jsp?notebk=<%=nbName%>">Create one by clicking here</a></h6>
			<%}
    		else{
				rs=ps.executeQuery();
				while(rs.next()){
					String name=rs.getString("noteName");
					String sDate= rs.getString("startDate");
					String eDate= rs.getString("endDate");
			%>
        <div class="container-fluid">
    	<div class="row">
            <div class="col m3 hide-on-small-only">
            <div class="left-content">
              &nbsp;
              <h5 class="blue-text"><%=name %></h5>
              <p><b>Start Date:</b><%=sDate %></p>
              <p><b>End Date:</b><%=eDate %></p>
            </div>
            </div>
            <div class="col m9 s12">
            <div class="right-content">
              <div class="container">
                <div class="row">
                    <div class="col s12">
                        <div class="card">
                            <div class="card-content">
                            <ul class="right">
                                <li><a href="editData.jsp"><i class="fas fa-edit"></i>&nbsp;Edit</a></li>
                                <li><a href="../DeleteNote?noteName=<%=name%>"><i class="fas fa-trash"></i>&nbsp;Delete</a></li>
                            </ul>
                            
                            <span class="card-title blue-text"><b><%=name%></b></span>
                            <span><b>Start Date:</b><%=sDate %>&nbsp;<button class="btn indigo waves-effect waves-light"><%=rs.getString("status") %></button></span> 
                        	</div>
                        </div>
                    </div>
                </div>
           </div>
           </div>
           </div>
        </div>
    	</div>
    	<%
       	}}}
       catch(Exception e){
    	   out.println(e);  
       	}    		
       	%>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://kit.fontawesome.com/52bf741a29.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
    	 <script>
            $(document).ready(function(){
                $('.sidenav').sidenav();
                $("#noticlick").click(function(){
                    $("#notification").fadeToggle();
                })
            })
        </script>
    </body>
</html>