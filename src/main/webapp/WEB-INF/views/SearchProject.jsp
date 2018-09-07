<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <link rel="shortcut icon" href="images/i2i.png" />
   <head>
      <title>Project Management</title>
<meta http-equiv='cache-control' content='no-cache'>
<meta http-equiv='expires' content='0'>
<meta http-equiv='pragma' content='no-cache'>
      <jsp:include page="access.jsp"/>
   </head>
   <body >
      <jsp:include page="header.jsp"/>
      <center>
         <h1>Project Management</h1>
      </center>
     <div class="row">
     <div class="col-xs-6">
     <form action="createProject" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Project</button>
     </form>
     </div>
     <div class="col-xs-6">
     <form action="displayProject" method="get">
     <button type="submit" class="btn btn-primary spacing leftpadding">Display All Project</button>
     </form>
     </div>
     </div>
<form action="searchProject" method="post">
  <input type="number" class="search" name="id" placeholder="Search Project By Id">
</form>
      <c:choose>
       <c:when test="${empty project}">
         <h2>Project not Found</h2>
       </c:when>
       <c:otherwise>         
      <div align="center">
         <table class="table">
            <thead>
               <caption>
                  <h2>${project.name}Details</h2>
               </caption>
               <tr>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>NUMBEROFRESOURCES</th>
                  <th>PROJECTCODE</th>
                  <th></th>
                  <th></th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <tr>
                  <td>
                     <c:out value="${project.id}" />
                  </td>
                  <td>
                     <c:out value="${project.name}" />
                  </td>
                  <td>
                     <c:out value="${project.numberOfResources}" />
                  </td>
                  <td>
                     <c:out value="${project.projectCode}" />
                  </td>
                     <td>
                        <form  action="assignEmployees" method="post" >
                           <input type="hidden" name="id" value="${project.id}">
                           <input type="submit" value="Assign Employee" class="btn btn-primary">
                        </form>
                     </td>
                     <td>
                        <form  action="modifyProject" method="post" >
                           <input type="hidden" name="id" value="${project.id}">
                           <input type="submit" value="Edit" class="btn btn-primary">
                        </form>
                     </td>
                     <td>
                        <form  action="deleteProject" method="post" >
                           <input type="hidden" name="id" value="${project.id}">
                           <input type="submit" value="Delete" class="btn btn-danger" onclick= "return confirm('Are you sure want to delete Project:${project.id} ?') ">
                        </form>
                     </td>
               </tr>
            </tbody>
            </table>
        <c:choose>
         <c:when test="${empty project.employees}">
         <h2> No Employees for Project:${project.id}.</h2>
        </c:when>
        <c:otherwise>
        <form action="removeEmployees" method="post">
         <table class="table">
            <thead>
               <caption>
                  <h2>List of Employees in Project:${project.id}</h2>
               </caption>
               <tr>
                  <th></th>
                  <th>EMPLOYEE_ID</th>
                  <th>EMPLOYEE_NAME</th>
               </tr>
             </thead>
             <tbody>
               <c:forEach var="employee" items="${project.employees}">
                  <tr>
                     <td> <input type="checkbox" name="employee" value="${employee.id}" unchecked> 
                     </td>
                     <td>
                        <c:out value="${employee.id}" />
                     </td>
                     <td>
                        <c:out value="${employee.name}" />
                     </td>
                     <td>
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <input type="hidden" name="id" value="${project.id}">
         <input type="submit" class="btn btn-primary" value="REMOVE EMPLOYEES" onclick= "return confirm('Are you Sure want to remove Employee from Project:${project.id} ?') "> 
       </form>
        </c:otherwise>
        </c:choose>
      </div>
      </c:otherwise>
     </c:choose>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
