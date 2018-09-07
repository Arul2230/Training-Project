<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <title>I2I Office Management </title>
   <head>
      <link rel="shortcut icon" href="images/i2i.png" />
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <META HTTP-EQUIV="Pragma" CONTENT="no-cache">
      <META HTTP-EQUIV="Expires" CONTENT="-1">
      <jsp:include page="access.jsp"/>
   </head>
   <body>
      <jsp:include page="header.jsp"/>
   <h1>I2I Office Management</h1>
   <h2><c:out value="${error}"/></h2>
   </body>
      <jsp:include page="footer.jsp"/>
</html>
