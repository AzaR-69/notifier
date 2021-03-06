<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*,java.sql.*,com.notebook.model.NotebookImplementation,com.notebook.model.Notebook"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Notebook</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="./assets/dashstyle.css" rel="stylesheet">
    </head>
    
    <body>
    	<%
    		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    		response.setHeader("Pragma","no-cache");
			response.setHeader("Expires","0");
			String mail=(String)session.getAttribute("email");
    		if(mail==null){
    			response.sendRedirect("../index.jsp");
    		}
    		NotebookImplementation nbi=new NotebookImplementation();
    		List<Notebook> notebooks=nbi.getNotebooks(mail);
    		boolean check=false;
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
                    <li><a href="newnotebook.jsp"><i class="fas fa-book-open"></i> &nbsp;New Notebook</a></li>
                    <li><a href="../logout"><i class="fas fa-sign-out-alt"></i>&nbsp;Logout</a></li>
                  </ul>
            </div>
        </nav>
       <h4 style="margin-left:30px;">NoteBooks</h4>
       
       <%try{
    		check=notebooks.isEmpty();
    		if(check){%>
    			<h5 style="text-align:center">No notebook is created</h5>
    			<h6 style="text-align:center"><a href="newnotebook.jsp">Create one by clicking here</a></h6>
    		<%}
    		else{
    			for(Notebook nb:notebooks){
    			String notebookName=nb.getNotebookName();
    			//HttpSession sus=request.getSession();
    			//session.setAttribute("NotebookName",nName);
    			int count=nb.getCount();
    			%>	
    			<div class="container" id="nbcol">
            	<div class="row">
                	<div class="col s12">
                    	<div class="card">
                        	<div class="card-content">
                            <ul class="right">
                                <li><a href="editData.jsp?noteBook=<%=notebookName%>"><i class="fas fa-edit"></i>&nbsp;Edit</a></li>
                                <li><a href="${pageContext.request.contextPath}/deleteNbook?notebookName=<%=notebookName%>"><i class="fas fa-trash"></i>&nbsp;Delete</a></li>
                            </ul>
                            <!-- form action="newnote.jsp">
                            <input type="submit" class="btn blue lighten-5 waves-effect waves-light blue-text" name="notebk" value="<%=notebookName%>">
                            </form-->
                            <span class="card-title"><a href="newnote.jsp?notebk=<%=notebookName%>"><b><%=notebookName%></b></a></span>
                            <p><b>No of notebooks:</b> <%=count %></p>
                        	</div>
                    	</div>
                	</div>
            	</div>
        		</div>     
       		
		<%
    		}
       	}}
       catch(Exception e){
    	   out.println(e);   
       	}    		
       	%>
       	
        <script src="https://kit.fontawesome.com/52bf741a29.js"></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
        <script>
            $(document).ready(function(){
                $('.sidenav').sidenav();
            })
        </script>
    </body>
</html>