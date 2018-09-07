<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

   <head>
      <title>Client Management</title>
   <link rel="shortcut icon" href="images/i2i.png" />
      <jsp:include page="access.jsp"/>
   </head>
   <body >
      <jsp:include page="header.jsp"/>
      <center>
         <h1>Client Management</h1>
      </center>
     <div class="row">
     <div class="col-xs-6">
     <form action="createClient" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Client</button>
     </form>
     </div>
     <div class="col-xs-6">
     <form action="displayClient" method="get">
     <button type="submit" class="btn btn-primary spacing leftpadding">Display All Client</button>
     </form>
     </div>
     </div>
<form action="searchClient" method="post">
  <input type="number" class="search" name="id" placeholder="Search Client By Id">
</form>
      <c:choose>
       <c:when test="${empty client}">
         <h2>Client not Found</h2>
       </c:when>
       <c:otherwise>         
      <div align="center">
         <table class="table">
            <thead>
               <caption>
                  <h2>${client.name} Details</h2>
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
            <tbody>
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
            </tbody>
         </table>
                  <div>
                  <table class="table table-bordered ">
                   <c:choose>
                     <c:when test="${empty client.addresses}">
                        <h2>No Address Details found</h2>
                     </c:when>
                   <c:otherwise>
                     <thead>
                        <caption>
                           <h2>
                              <c:out value="${client.name}" />
                              's Address Details
                           </h2>
                        </caption>
                        <tr>
                           <th>DOOR NUMBER</th>
                           <th>STREET NAME</th>
                           <th>CITY</th>
                           <th>STATE</th>
                           <th>COUNTRY</th>
                           <th>PINCODE</th>
                           <th>ADDRESS TYPE</th>
                        </tr>
                     </thead>
                     <tbody>
                        <c:forEach var="address" items="${client.addresses}">
                           <tr>
                              <td>
                                 <c:out value="${address.doorNumber}" />
                              </td>
                              <td>
                                 <c:out value="${address.streetName}" />
                              </td>
                              <td>
                                 <c:out value="${address.city}" />
                              </td>
                              <td>
                                 <c:out value="${address.state}" />
                              </td>
                              <td>
                                 <c:out value="${address.country}" />
                              </td>
                              <td>
                                 <c:out value="${address.pincode}" />
                              </td>
                              <td>
                                 <c:out value="${address.addressType}" />
                              </td>
                           </tr>
                        </c:forEach>
                     </tbody>
                     </c:otherwise>
                     </c:choose>
                  </table>
      </div>
        <c:choose>
         <c:when test="${empty client.projects}">
         <h2> No Projects for Client:${client.name}.</h2>
        </c:when>
        <c:otherwise>
        <form action="removeProjects" method="post">
         <table class="table">
            <thead>
               <caption>
                  <h2>List of Projects in Client:${client.id}</h2>
               </caption>
               <tr>
                  <th></th>
                  <th>EMPLOYEE_ID</th>
                  <th>EMPLOYEE_NAME</th>
               </tr>
             </thead>
             <tbody>
               <c:forEach var="project" items="${client.projects}">
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
                     </td>
                  </tr>
               </c:forEach>
            </tbody>
         </table>
         <input type="hidden" name="clientId" value="${client.id}">
         <input type="submit" class="btn btn-primary" value="REMOVE PROJECTS" onclick= "return confirm('Are you Sure want to remove Projects from Client:${client.id} ?') "> <br><br><br>
       </form>
        </c:otherwise>
        </c:choose>
      </div>
        </c:otherwise>
        </c:choose>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
