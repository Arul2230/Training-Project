<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link rel="shortcut icon" href="images/i2i.png" />
      <META HTTP-EQUIV="Pragma" CONTENT="no-cache"/>
      <META HTTP-EQUIV="Expires" CONTENT="-1"/>
      <jsp:include page="access.jsp"/>
   </head>
   <body>
      <jsp:include page="header.jsp"/>
      <center>
         <h1>Client Management</h1>
      </center>
      <c:choose>
         <c:when test="${empty client.id}">
            <c:set var="value" value="addClient"/>
         </c:when>
         <c:otherwise>
            <c:set var="value" value="updateClient"/>
         </c:otherwise>
      </c:choose>
      <div class="row">
         <form:form  action="${value}" commandName="client">
            <div class="col-md-4">
               <fieldset>
                  <legend>
                     <c:if test="${empty client.id}">
                        Add Client Details
                     </c:if>
                     <c:if test="${not empty client.id}">
                        Modify Client Details
                     </c:if>
                  </legend>
                  <div>
                     <label for="name">Name</label>
                     <form:input path="name" pattern="^[a-zA-Z]{1,20}$" class ="form-control spacing" required="required"/>
                  </div>
                  <div>
                     <label for="companyName">Company Name</label>
                     <form:input path="companyName" pattern="^[a-zA-Z]{1,20}$" required="required"
                        id="companyName" class ="form-control spacing"  />
                  </div>
                  <div>
                     <label for="emailId">Email Id</label>
                     <form:input type="emailId"  path="emailId" required="required" pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$"
                        id="emailId" class ="form-control spacing" />
                  </div>
                  <c:if test="${not empty client.id}">
                     <form:input type="hidden" path="id" />
                     <form:input type="hidden" path="isActive" />
                  </c:if>
            </div>
            <c:forEach items="${client.addresses}" varStatus="vs">
            <div class="col-md-4">
            <c:choose>
            <c:when test="${vs.index == 0}">
            <legend>Present Address</legend>
            </c:when>
            <c:otherwise>
            <legend>Permanent Address</legend>
            </c:otherwise>
            </c:choose>
            <br>
            <form:hidden path="addresses[${vs.index}].addressType"/>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="doorNumber">Door Number</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].doorNumber" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].doorNumber" placeholder="DoorNumber"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="streetName">Street Name</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].streetName" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].streetName" placeholder="StreetName" />
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="city">City</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].city" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].city" placeholder="City" class="form-control"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="state">State</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].state"  class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].state"  placeholder="State" class="form-control"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="Postcode">Postcode</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].pincode" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].pincode" placeholder="Post Code" class="form-control"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="country">Country</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].country" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].country" placeholder="Country"  class="form-control"/>
            </div>
            </div>
            </div>
            </c:forEach>
      </div>
      </div></div></div></div></div>
      </fieldset>
      <div style="text-align:center">
      <c:choose>
      <c:when test="${empty client.id}">
      <input type="submit" class="btn btn-info center" value="CREATE CLIENT" >
      </c:when>
      <c:otherwise>
      <input type="submit" class="btn btn-info center" value="MODIFY CLIENT" onclick= "return confirm('Sure want to make changes for Client :${client.id} ?')"   >
      </c:otherwise>
      </c:choose>
      </div> 
      </form:form>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
