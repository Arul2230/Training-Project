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
         <h1>Employee Management</h1>
      </center>
     <div class="row">
     <div class="col-sm-10">
     <form action="createEmployee" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Employee</button>
     </form>
     </div>
     <div class="col-sm-10">
     <form action="searchEmployee" method="post">
      <input type="number" class="search" name="id" placeholder="Search Employee By Id">
     </form>
     </div>
     </div>
      <div align="center" overflow="scroll">
         <table class ="table">
            <thead>
               <caption>
                  <h2>List of Employees</h2>
               </caption>
               <tr>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>ROLE</th>
                  <th>SALARY</th>
                  <th>EMAIL ID</th>
                  <th>DATE OF BIRTH</th>
                  <th>DATE OF JOIN</th>
                  <th>AGE</th>
                  <th></th>
                  <th></th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="employee" items="${employees}">
                  <tr>
                     <td style="display:none">
                       <c:choose>
                        <c:when test="${employee.isActive}">
                          <c:out value="1"/>
                        </c:when>
                        <c:otherwise>
                          <c:out value="0"/>
                        </c:otherwise>
                      </c:choose>   
                     </td>                         
                     <td>
                        <input type="hidden" value="${employee.isActive}" />
                        <c:out value="${employee.id}" />
                     </td>
                     <td>
                        <c:out value="${employee.name}" />
                     </td>
                     <td>
                        <c:out value="${employee.role}" />
                     </td>
                     <td>
                        <c:out value="${employee.salary}" />
                     </td>
                     <td>
                        <c:out value="${employee.emailId}" />
                     </td>
                     <td>
                        <c:out value="${employee.birthDate}" />
                     </td>
                     <td>
                        <c:out value="${employee.dateOfJoin}" />
                     </td>
                     <td>
                        <c:out value="${employee.age}" />
                     </td>
                     <c:choose>
                       <c:when test="${employee.isActive == true}">
                         <td>
                           <form  action="modifyEmployee" method="post" >
                             <input type="hidden" name="id" value="${employee.id}" />
                             <input type="submit" value="Edit" class="btn btn-primary">
                           </form>
                         </td>
                         <td>
                           <form  action="deleteEmployee" method="post" >
                             <input type="hidden" name="id" value="${employee.id}" />
                              <input type="submit" value="Delete" class="btn btn-danger" onclick= "return confirm('Are you sure want to delete Employee :${employee.id} ?') ">
                           </form>
                         </td>
                         <td>
                           <form  action="searchEmployee" method="post" >
                             <input type="hidden" name="id" value="${employee.id}" />
                              <input type="submit" value="View Details" class="btn btn-info">
                           </form>
                         </td>
                       </c:when>
                       <c:otherwise>
                         <td>
                           <form  action="activateEmployee" method="post" >
                             <input type="submit" value="Activate" class="btn btn-primary" onclick= "return confirm('Are you sure want to Activate Employee :${employee.id} ?')"/>
                             <input type="hidden" name="id" value="${employee.id}" />
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
