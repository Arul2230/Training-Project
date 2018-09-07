<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link rel="shortcut icon" href="images/i2i.png" />
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
     <div class="col-xs-6">
     <form action="createEmployee" method="get">
     <button type="submit" class="btn btn-primary spacing leftpad">Create Employee</button>
     </form>
     </div>
     <div class="col-xs-6">
     <form action="displayEmployee" method="get">
     <button type="submit" class="btn btn-primary spacing leftpadding">Display All Employee</button>
     </form>
     </div>
     </div>
<form action="searchEmployee" method="post">
  <input type="number" class="search" name="id" placeholder="Search Employee By Id">
</form>
      <c:choose>
       <c:when test="${empty employee}">
         <h2>Employee not Found</h2>
       </c:when>
       <c:otherwise>         
      <div align="center">
         <table class="table">
            <thead>
               <caption>
                  <h2>${employee.name} Details</h2>
               </caption>
               <tr>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>ROLE</th>
                  <th>SALARY</th>
                  <th>EMAILID</th>
                  <th>DATEOFBIRTH</th>
                  <th>DATEOFJOIN</th>
                  <th>AGE</th>
                  <th></th>
                  <th></th>
               </tr>
            </thead>
            <tbody>
               <tr>
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
                       </c:when>
                       <c:otherwise>
                         <td>
                           <form  action="activateEmployee" method="post" >
                             <input type="submit" value="Active" class="btn btn-info">
                             <input type="hidden" name="id" value="${employee.id}" />
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
                     <c:when test="${empty employee.addresses}">
                        <h2>No Address Details found</h2>
                     </c:when>
                   <c:otherwise>
                     <thead>
                        <caption>
                           <h2>
                              <c:out value="${employee.name}" />
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
                        <c:forEach var="address" items="${employee.addresses}">
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
                  <div>
                  <table class="table table-bordered ">
                   <c:choose>
                     <c:when test="${empty employee.projects}">
                        <h2>No Project Details found</h2>
                     </c:when>
                   <c:otherwise>
                   <thead>
                        <caption>
                           <h2>
                              <c:out value="${employee.name}" />
                              's Project Details
                           </h2>
                        </caption>               <tr>
                  <th>ID</th>
                  <th>NAME</th>
                  <th>NUMBEROFRESOURCES</th>
                  <th>PROJECTCODE</th>
               </tr>
            </thead>
            <tbody>
               <c:forEach var="project" items="${employee.projects}">
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
               </tr>
                        </c:forEach>
            </tbody>
            </table>
                     </c:otherwise>
                     </c:choose>
      </div><br><br>

                     </c:otherwise>
                     </c:choose>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
