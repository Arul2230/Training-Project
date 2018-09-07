<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
      <nav class="navbar navbar-inverse">
         <div class="container-fluid">
         <div class="navbar-header">
            <a class="navbar-brand" href="index">I2I WEB Office Management</a>
         </div>
         <ul class="nav navbar-nav">
            <c:if test="${sessionScope.role == 'admin'}">
               <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="client">Client<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                     <li><a href="createClient">Create Client</a></li>
                     <li><a href="displayClient">Display All Client</a></li>
                  </ul>
               </li>
            </c:if>
            <c:if test="${sessionScope.role == 'admin'}">
               <li class="dropdown">
                  <a class="dropdown-toggle" data-toggle="dropdown" href="project">Project<span class="caret"></span></a>
                  <ul class="dropdown-menu">
                     <li><a href="createProject">Create Project</a></li>
                     <li><a href="displayProject">Display All Project </a></li>
                  </ul>
               </li>
            </c:if>
            <li class="dropdown">
               <a class="dropdown-toggle" data-toggle="dropdown" href="employee">Employee<span class="caret"></span></a>
               <ul class="dropdown-menu">
                  <li><a href="createEmployee">Create Employee</a></li>
                  <li><a href="displayEmployee">Display All Employee</a></li>
               </ul>
            </li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
            <li><a href="logout" method=get><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
         </ul>
         <ul class="nav navbar-nav navbar-right">
            <li><a href="#">${emailid}</a></li>
         </ul>
      </nav>
