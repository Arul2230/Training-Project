<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <link rel="shortcut icon" href="images/i2i.png" />
   <head>
      <title>Project Management</title>
      <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
      <META HTTP-EQUIV="Expires" CONTENT="-1">
      <jsp:include page="access.jsp"/>
   </head>
   <body >
      <jsp:include page="header.jsp"/>
      <center>
         <h1>Project Management</h1>
      </center>

     <div class="row">
     <div class="col-sm-10">
     <form action="createProject" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Project</button>
     </form>
     </div>
     <div class="col-sm-10">
     <form action="searchProject" method="post">
      <input type="number" class="search" name="id" placeholder="Search Project By Id">
     </form>
     </div>
     </div>

      <div align="center" overflow="scroll">
         <table class="table">
            <thead>
               <caption>
                  <h2>List of Projects</h2>
               </caption>
               <tr>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>NUMBEROFRESOURCES</th>
                  <th>PROJECTCODE</th>
                  <th></th>
                  <th></th>
                  <th></th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="project" items="${projects}">
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
                     <c:choose>
                       <c:when test="${project.isActive == true}">
                     <td>
                        <form  action="assignEmployees" method="post" >
                           <input type="hidden" name="id" value="${project.id}"/>
                           <input type="submit" value="Assign Employees" class="btn btn-primary">
                        </form>
                     </td>
                     <td>
                        <form  action="modifyProject" method="post" >
                           <input type="hidden" name="id" value="${project.id}"/>
                           <input type="submit" value="Edit" class="btn btn-primary">
                        </form>
                     </td>
                     <td>
                        <form  action="deleteProject" method="post" >
                           <input type="hidden" name="id" value="${project.id}"/>
                           <input type="submit" value="Delete Project" class="btn btn-danger" onclick= "return confirm('Are you sure want to delete Project:${project.id} ?') "/>
                        </form>
                     </td>
                     <td>
                       <form action="searchProject" method="post">
                           <input type="hidden" name="id" value="${project.id}"/>
                           <input type="submit" value="Employee Details" class="btn btn-info">
                       </form>
                     </td>
                       </c:when>
                       <c:otherwise>
                         <td>
                           <form  action="activateProject" method="post" >
                             <input type="submit" value="Active Project" class="btn btn-primary" onclick= "return confirm('Are you sure want to Activate Project :${project.id} ?')"/>
                             <input type="hidden" name="id" value="${project.id}" />
                           </form>
                         </td>
                       </c:otherwise>
                     </c:choose>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
      </div>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
