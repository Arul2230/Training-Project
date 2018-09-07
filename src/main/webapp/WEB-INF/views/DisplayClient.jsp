<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link rel="shortcut icon" href="images/i2i.png" />
      <title>Client Management</title>
      <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
      <META HTTP-EQUIV="Expires" CONTENT="-1">
      <jsp:include page="access.jsp"/>
   </head>
   <body>
      <jsp:include page="header.jsp"/>
      <center>
         <h1>Client Management</h1>
      </center>
     <div class="row">
     <div class="col-sm-10">
     <form action="createClient" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Client</button>
     </form>
     </div>
     <div class="col-sm-10">
     <form action="searchClient" method="post">
      <input type="number" class="search" name="id" placeholder="Search Client By Id">
     </form>
     </div>
     </div>
      <table class="table table-hover" >
         <thead>
            <caption>
               <h2>List of Clients</h2>
            </caption>
            <tr>
               <th>ID</th>
               <th>NAME</th>
               <th>COMPANYNAME</th>
               <th>EMAILID</th>
               <th></th>
               <th></th>
               <th></th>
               <th></th>
            </tr>
         </thead>
         <tbody id="myTable">
            <c:forEach var="client" items="${clients}">
               <tr>
                  <td>
                     <c:out value="${client.id}" />
                  </td>
                  <td>
                     <c:out value="${client.name}" />
                  </td>
                  <td>
                     <c:out value="${client.companyName}" />
                  </td>
                  <td>
                     <c:out value="${client.emailId}" />
                  </td>
                     <c:choose>
                       <c:when test="${client.isActive == true}">
                  <td>
                     <form  action="assignProjects" method="post" >
                        <input type ="hidden" name="clientId" value="${client.id}"/>
                        <input type="submit" value="Assign Project" class="btn btn-primary"/>
                     </form>
                  </td>
                  <td>
                     <form  action="modifyClient" method="post">
                        <input type="submit" value="Edit" class="btn btn-primary"/>
                        <input type ="hidden" name="clientId" value="${client.id}"/>
                     </form>
                  </td>
                  <td>
                     <form  action="deleteClient" method="post">
                        <input type ="hidden" name="clientId" value="${client.id}"/>
                        <input type="submit" value="Delete" class="btn btn-danger" onclick= "return confirm('Are you sure want to delete Client :${client.id} ?') "/>
                     </form>
                  </td>
                         <td>
                           <form  action="searchClient" method="post" >
                             <input type="hidden" name="id" value="${client.id}" />
                              <input type="submit" value="View Details" class="btn btn-info">
                           </form>
                         </td>
                       </c:when>
                       <c:otherwise>
                         <td>
                           <form  action="activateClient" method="post" >
                             <input type="submit" value="Activate Client" class="btn btn-primary" onclick= "return confirm('Are you sure want to Activate Client :${client.id} ?')"/>
                             <input type="hidden" name="id" value="${client.id}" />
                           </form>
                         </td>
                       </c:otherwise>
                     </c:choose>
               </tr>
          </c:forEach>
         </tbody>
      </table>
   </body>

   <jsp:include page="footer.jsp"/>
</html>
