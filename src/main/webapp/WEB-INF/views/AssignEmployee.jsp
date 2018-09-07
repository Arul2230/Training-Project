<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <link rel="shortcut icon" href="images/i2i.png" />
   <head>
      <title>Employee Management</title>
      <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
      <META HTTP-EQUIV="Expires" CONTENT="-1">
      <jsp:include page="access.jsp"/>
   </head>
   <body >
      <jsp:include page="header.jsp"/>
      <center>
         <h1>Assign Employees for Project:${project.id}</h1>
      </center>
      <div align="center" class="container" overflow="scroll">
  <input class="form-control" id="myInput" type="text" placeholder="Search Employee">
      <form method="post" action="assignEmployeesToProject">
         <table class ="table table-bordered table-striped">
            <thead>
               <caption>
                  <h2>List of Employees</h2>
               </caption>
               <tr>
                  <th></th>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>ROLE</th>
                  <th>EMAILID</th>
               </tr>
            </thead>
            <tbody id="myTable">
               <c:forEach var="employee" items="${checked}">
                  <tr>
                     <td> <input type="checkbox" name="employee" value="${employee.id}" checked> 
                     </td>
                     <td>
                        <c:out value="${employee.id}" />
                     </td>
                     <td>
                        <c:out value="${employee.name}" />
                     </td>
                     <td>
                        <c:out value="${employee.role}" />
                     </td>
                     <td>
                        <c:out value="${employee.emailId}" />
                     </td>
                  </tr>
               </c:forEach>
               <c:forEach var="employee" items="${employees}">
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
                        <c:out value="${employee.role}" />
                     </td>
                     <td>
                        <c:out value="${employee.emailId}" />
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <input type ="hidden" name="id" value="${project.id}"/>
         <input type="submit" class="btn btn-primary" value="ASSIGN EMPLOYEES" onclick="return confirm('Are you sure want to make these Changes ?') "> 
        </form>
      </div>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
