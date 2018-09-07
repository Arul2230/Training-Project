<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link rel="shortcut icon" href="images/i2i.png" />
      <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
      <META HTTP-EQUIV="Expires" CONTENT="-1">
      <jsp:include page="access.jsp"/>
   </head>
   <body>
      <jsp:include page="header.jsp"/>
      <center>
         <h1>Project Management</h1>
      </center>
      <c:choose>
         <c:when test="${empty project.id}">
            <c:set var="value" value="addProject"/>
         </c:when>
         <c:otherwise>
            <c:set var="value" value="updateProject"/>
         </c:otherwise>
      </c:choose>
      <div class="row">
         <div class="col-md-4">
         </div>
         <div class="col-md-4">
               <form:form action="${value}" commandName="project">
                     <div class="spacing">
                        <c:if test="${empty project.id}">
                           <h2>Add Project Details</h2>
                        </c:if>
                        <c:if test="${not empty project.id}">
                           <h2>Modify Project Details</h2>
                        </c:if>
                     </div>
                  <div class="row">
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="name">Name</label>
                     <div class="col-sm-10">
                        <form:input path="name" pattern="^[a-zA-Z]{1,20}$" required="required" class ="form-control spacing" />
                     </div>
                  </div>
                  </div>
                  <div class="row">
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="numberOfResources">Numberof Resource</label>
                     <div class="col-sm-10">
                        <form:input type="number" path="numberOfResources" class ="form-control spacing" />
                     </div>
                  </div>
                  </div>
                  <div class="row">
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="projectCode">ProjectCode</label> 
                     <div class="col-sm-10">
                        <form:input path="projectCode" class ="form-control spacing" />
                     </div>
                  </div>
                  </div>
                        <form:hidden path="clientId"/>
                  <c:if test="${not empty project.id}">
                     <input type="hidden" name="id" value="${project.id}" />
                  </c:if>
                  <br>
      <div style="text-align:center">
      <c:choose>
      <c:when test="${empty project.id}">
      <input type="submit" class="btn btn-info center" value="CREATE PROJECT" >
      </c:when>
      <c:otherwise>
      <input type="submit" class="btn btn-info center" value="MODIFY PROJECT" onclick= "return confirm('Sure want to make changes for Project :${project.id} ?')" >
      </c:otherwise>
      </c:choose>
      </div>
               </form:form>
            </div>
         <div class="col-md-4"></div>
      </div>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
