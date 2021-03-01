<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Notes</title>
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
            ::placeholder{
                color:rgb(51, 48, 48);
                opacity: 0.6;
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
                <ul class="right" id="right-bar">
                    <li><a href="../logout"><i class="fas fa-sign-out-alt"></i>&nbsp;Logout</a></li>
                  </ul>
            </div>
        </nav>
        <h4 style="margin-left:25px">Notes</h4>
        <div class="row">
            <div class="col s9">
              <div class="container">
                <div class="row">
                    <div class="col s12 m4 offset-m4" id="ucol">
                        <div class="card">
                            <div class="card-action">
                            </div>
                            <div class="card-content">
                                <div class="form-field">
                                    <form action="../newNote?notebookName=<%=request.getParameter("notebk")%>" method="post">
                                    	<!--label for="notename"> NoteBookName</label>
                                        <input type="text" name="notebookName" placeholder="NoteBook Name"-->
                                        <label for="notename"> NoteName</label>
                                        <input type="text" name="notename" placeholder="NoteName">
                                        <label for="sdate"> StartDate</label>
                                        <input type="date" name="sdate" placeholder="StartDate">
                                        <label for="edate"> EndDate</label>
                                        <input type="date" name="edate" placeholder="EndDate">
                                        <label for="rdate"> RemainderDate</label>
                                        <input type="date" name="rdate" placeholder="RemainderDate">
                                        <div class="input-field col s12">
                                            <select name="status">
                                              <option value="Started">Started</option>
                                              <option value="Not Started">Not Started</option>
                                            </select>
                                            <label>Status</label>
                                        </div>
                                        <div class="input-field col s12">
                                            <select name="tag">
                                              <option value="private">Private</option>
                                              <option value="public">Public</option>
                                            </select>
                                            <label>Tag</label>
                                        </div>
                                        <textarea name="desc" id="desc" cols="30" rows="4" placeholder="Description"></textarea>&nbsp;
                                        <div class="button" style="text-align: center;">
                                            <button class="btn-large indigo waves-effect waves-light" type="submit">Submit</button>
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
        
        <script src="https://kit.fontawesome.com/52bf741a29.js"></script>
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