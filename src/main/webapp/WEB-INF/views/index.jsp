<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
   <title>I2I Office Management </title>
   <link rel="shortcut icon" href="
   <c:url value="/resources/images/i2i.png" />">
      <jsp:include page="access.jsp"/>
   </head>
   <body>
      <jsp:include page="header.jsp"/>
      <h1>I2I Web Office Management</h1>
      <div class="container paddingtop">
         <div class="row ">
            <div class="col-sm-4 main-menu">
               <c:choose>
                  <c:when test="${sessionScope.role == 'admin'}">
                     <a href ="displayClient">
                  </c:when>
                  <c:otherwise>
                  <a href ="#">
                  </c:otherwise>
               </c:choose>
               <img src="<c:url value="/resources/images/man-5.png"/>"
               class="img-responsive "/>
               </a>
            </div>
            <div class="col-sm-4 main-menu">
               <c:choose>
                  <c:when test="${sessionScope.role == 'admin'}">
                     <a href ="displayProject">
                  </c:when>
                  <c:otherwise>
                  <a href ="#">
                  </c:otherwise>
               </c:choose>
               <img class="img-responsive" src="<c:url value="/resources/images/project.png"/>"/> </a>
            </div>
            <div class="col-sm-4 main-menu">
               <a href ="displayEmployee">
                  <img class="img-responsive " src="
                  <c:url value="/resources/images/employee.png"/>
                  "/>
               </a>
            </div>
         </div>
      </div>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
