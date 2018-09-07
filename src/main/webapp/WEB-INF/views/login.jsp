<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
      <link rel="stylesheet" href="
      <c:url value="/resources/css/login.css"/>
      ">
   </head>
   <body>
      <div class="container">
         <div class="row">
            <div class="col-md-6 col-md-offset-3">
               <div class="panel panel-login">
                  <div class="panel-heading">
                     <div class="row">
                        <div class="col-xs-6">
                           <a href="#" class="active" id="login-form-link">Login</a>
                        </div>
                        <div class="col-xs-6">
                           <a href="#" id="register-form-link">Register</a>
                        </div>
                     </div>
                  </div>
                  <div class="panel-body">
                     <div class="row">
                        <div class="col-lg-12">
                           <form id="login-form" action="login" method="post" role="form" style="display: block;">
                              <div class="form-group">
                                 <input type="email" name ="emailid" class="form-control" placeholder="Email Address" required value="${emailid}">
                              </div>
                              <div class="form-group">
                                 <input type="password" name="password" class="form-control" required placeholder="Password">
                              </div>
                              <div class="form-group">
                                 <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3">
                                       <input type="submit" name="login" id="login-submit" tabindex="4" class="form-control btn btn-login " value="Log In" >
                                    </div>
                                 </div>
                              </div>
                              <div style="color:red;"> ${user}
                              </div>
                           </form>
                           <form id="register-form" action="register" method="post" role="form" style="display: none;">
                              <div class="form-group">
                                 <input type="email" name="emailid" required id="email" tabindex="1" class="form-control" placeholder="Email Address" value="">
                              </div>
                              <div class="form-group">
                                 <select class ="form-control" name="role" required>
                                    <option value="" disabled selected>Select UserRole</option>
                                    <option value="admin">Admin</option>
                                    <option value="employee">Employee</option>
                                 </select>
                              </div>
                              <div class="form-group">
                                 <input type="password" name="password" id="password" tabindex="2" class="form-control" placeholder="Password" required onkeyup='check();'>
                              </div>
                              <div class="form-group">
                                 <input type="password" name="confirm-password" id="confirm-password" tabindex="2" class="form-control" placeholder="Confirm Password" required onkeyup='check();'>
                                 <span id='message'></span>
                              </div>
                              <div class="form-group ">
                                 <div class="row">
                                    <div class="col-sm-6 col-sm-offset-3 ">
                                       <input type="submit" name="register" id="register-submit" tabindex="4" class="form-control btn btn-register con"  value="Register" disabled>
                                    </div>
                                 </div>
                              </div>
                           </form>
                        </div>
                     </div>
                  </div>
               </div>
            </div>
         </div>
      </div>
   </body>
   <script src="/resources/js/jquery.min.js"></script>
   <script src="/resources/js/bootstrap.min.js"></script>
   <script src="/resources/js/login.js"></script>
</html>
