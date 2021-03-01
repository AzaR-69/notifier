<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.sql.*,java.time.*"%>

<!DOCTYPE html>
<html>
    <head>
        <title>Edit</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/css/materialize.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link href="./assets/dashstyle.css" rel="stylesheet">
        <style>
            .container{
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translateX(-50%) translateY(-50%);
            }
        </style>
    </head>
    <body>
    	<%
    		response.setHeader("Cache-Control","no-cache, no-store, must-revalidate");
    		response.setHeader("Pragma","no-cache");
			response.setHeader("Expires","0");
			String mail=(String)session.getAttribute("email");
    		if(mail==null){
    			response.sendRedirect("index.jsp");
    		}
   		%>
        <nav class="nav-wrapper indigo"> 
            <div class="cont">
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
                <ul class="right"  id="right-bar">
                    <li><a href="../logout"><i class="fas fa-sign-out-alt"></i>&nbsp;Logout</a></li>
                  </ul>
            </div>
        </nav>
        <div class="row">
            <div class="col s9">
              <div class="container">
                <div class="row">
					<div class="col s12 m4 offset-m4" id="ucol">
						<div class="card">
							<div class="card-action">
								<h5 style="text-align: center; font-weight: bold;">Enter
									the following</h5>
							</div>
							<div class="card-content">
								<div class="form-field">
									<form
										action="../EditData?oldname=<%=request.getParameter("noteBook")%>"
										method="post">
										<div class="radio">
											<p style="font-size: large;">Choose which one you want to
												edit</p>
											<br> <label> <input type="radio"
												value="notebook" name="option" checked /> <span>Notebook</span>
											</label> <label> <input type="radio" value="notes"
												name="option"> <span>Note</span>
											</label>
										</div>
										&nbsp; <input type="text" name="name"
											placeholder="Name of the notebook/note" required>
										&nbsp; <br>
										<div class="button" style="text-align: center;">
											<button class="btn-large indigo waves-effect waves-light"
												type="submit">Submit</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</div>
				</div>
            </div>
            </div>
          </div>
        
        <script src="https://kit.fontawesome.com/52bf741a29.js" ></script>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0-beta/js/materialize.min.js"></script>
        <script>
            $(document).ready(function(){
                $('select').formSelect();
                $('.sidenav').sidenav();
            })
        </script>
    </body>
</html>