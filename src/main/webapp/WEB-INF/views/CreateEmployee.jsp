<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link rel="shortcut icon" href="images/i2i.png" />
      <jsp:include page="access.jsp"/>
   </head>
   <body>
      <jsp:include page="header.jsp"/>
      <center>
         <h1>Employee Management</h1>
      </center>
      <c:choose>
         <c:when test="${empty employee.id}">
            <c:set var="value" value="addEmployee"/>
         </c:when>
         <c:otherwise>
            <c:set var="value" value="updateEmployee"/>
         </c:otherwise>
      </c:choose>
      <div class="row">
         <form:form  action="${value}" commandName="employee">
            <div class="col-md-4">
               <fieldset>
                  <legend>
                     <c:if test="${empty employee.id}">
                        Add Employee Details
                     </c:if>
                     <c:if test="${not empty employee.id}">
                        Modify Employee
                     </c:if>
                  </legend>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="name">Name</label>
                     <div class="col-sm-10">
                        <form:input path="name" pattern="^[a-zA-Z]{1,20}$" class ="form-control spacing" required="required" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="role">Role</label>
                     <div class="col-sm-10">
                        <form:input path="role" pattern="^[a-zA-Z]{1,20}$" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="salary">Salary</label>
                     <div class="col-sm-10">
                        <form:input path="salary" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="emailid">EmailId</label>
                     <div class="col-sm-10">
                        <form:input type="email" path="emailId" pattern="^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="birthdate">DOB</label>
                     <div class="col-sm-10">
                        <form:input type="date" id="DOB" path="birthDate" required="required" class ="form-control spacing" />
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="col-sm-2 control-label" for="joindate">Date Of Join</label>
                     <div class="col-sm-10">
                        <form:input type="date" id="DOJ" path="dateOfJoin" class ="form-control spacing" />
                     </div>
                  </div>
                  <c:if test="${not empty employee.id}">
                     <input type="hidden" name="id" value="${employee.id}" />
                  </c:if>
            </div>
            <c:forEach items="${employee.addresses}" varStatus="vs">
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
            <form:errors path="addresses[${vs.index}].streetName" placeholder="StreetName"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="city">City</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].city" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].city" placeholder="City"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="state">State</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].state" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].state"  placeholder="State"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="Postcode">Postcode</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].pincode" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].pincode" placeholder="Post Code"/>
            </div>
            </div>
            <div class="form-group">
            <label class="col-sm-2 control-label" for="country">Country</label>
            <div class="col-sm-10">
            <form:input path="addresses[${vs.index}].country" class="form-control spacing"/>
            <form:errors path="addresses[${vs.index}].country" placeholder="Country"/>
            </div>
            </div>
            </div>
            </c:forEach>
      </div>
      </div></div></div></div></div>
      </fieldset>
      <br>
      <div style="text-align:center">
      <c:choose>
      <c:when test="${empty employee.id}">
      <input type="submit" class="btn btn-info center" value="CREATE EMPLOYEE" >
      </c:when>
      <c:otherwise>
      <input type="submit" class="btn btn-info center" value="MODIFY EMPLOYEE" onclick= "return confirm('Sure want to make changes for Employee :${employee.id} ?')" >
      </c:otherwise>
      </c:choose>
      </div>
      </form:form>
   </body>
   <jsp:include page="footer.jsp"/>
</html>
