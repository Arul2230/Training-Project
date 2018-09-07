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
         <h1>Assign Projects for Client:${client.name}</h1>
      </center>
      <div align="center" class="container" overflow="scroll">
  <input class="form-control" id="myInput" type="text" placeholder="Search Project">
      <form method="post" action="assignProjectsToClient">
         <table class ="table table-bordered table-striped">
            <thead>
               <caption>
                  <h2>List of Projects</h2>
               </caption>
               <tr>
                  <th></th>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>PROJECTCODE</th>
               </tr>
            </thead>
            <tbody  id="myTable">
               <c:forEach var="project" items="${checked}">
                  <tr>
                     <td> <input type="checkbox" name="project" value="${project.id}" checked> 
                     </td>
                     <td>
                        <c:out value="${project.id}" />
                     </td>
                     <td>
                        <c:out value="${project.name}" />
                     </td>
                     <td>
                        <c:out value="${project.projectCode}" />
                     </td>
                  </tr>
               </c:forEach>
               <c:forEach var="project" items="${projects}">
                  <tr>
                     <td> <input type="checkbox" name="project" value="${project.id}" unchecked> 
                     </td>
                     <td>
                        <c:out value="${project.id}" />
                     </td>
                     <td>
                        <c:out value="${project.name}" />
                     </td>
                     <td>
                        <c:out value="${project.projectCode}" />
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <input type ="hidden" name="clientId" value="${client.id}"/>
         <input type="submit" class="btn btn-primary" value="ASSIGN PROJECTS" onclick= "return confirm('Are you sure want to make these Changes ?') "> 
        </form>
      </div>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
