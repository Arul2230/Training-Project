package com.ideas2it.employeeinformation.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ideas2it.employeeinformation.commons.constants.Constants;
import com.ideas2it.employeeinformation.user.model.User;
import com.ideas2it.employeeinformation.user.service.UserService;
import com.ideas2it.employeeinformation.user.service.impl.UserServiceImpl;
import com.ideas2it.employeeinformation.exception.ApplicationException;
import com.ideas2it.employeeinformation.logger.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
  
/**
 * UserController is the controller class for the User, which allows
 * the application to execute the data manipulation operations of the
 * User Details.
 * <p>
 * The Operations that can be done using this application are Adding a
 * User Details, Searching for a User details.
 * </p>
 *
 * @author    Arul Murugan
 * @version   1.0
 */
@Controller
public class UserController extends HttpServlet {

    private static UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    /**
     * <p>
     * This method is called once when the Servlet is created. It is used to
     * check whether the Servlet is successfully Initialized or not.
     * </p>
     */
    public void init() throws ServletException {
        System.out.println("User"+Constants.SERVLET_STARTED);
    }

    /**
     * <p>
     * This method is used by the Servlet to implement the Display,Create,
     * Modify and Search operations on the Employee Details. This method called
     * by the Servlet to process these operations on the Employee.
     * </p>
     *
     * @param request contains the HttpServletRequest send by the Servlet.
     * @param response contains the HttpServletResponse send by the Servlet.
     */
    @RequestMapping(value="/register", method = RequestMethod.POST)
    public ModelAndView register(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        try {
            User user = getUser(request);
            userService.addUser(user);
            return new ModelAndView(Constants.LOGINFILE, Constants.EMAILID,
                user.getEmailId());
        } catch(ApplicationException e) {
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * Gets the Employee Details and set it to the Employee Object using the
     * getters and setters funtions and this method will be gathering the
     * employeeDetails using scanner and the Employee Object will be returned.
     * </p>
     *
     * @param request contains the HttpServletRequest send by the Servlet.
     * @return  employee  returns when employee details are stored
     *                    successfully.
     */
    private User getUser(final HttpServletRequest request) {

        User user = null;
        user = new User();
        user.setRole(request.getParameter(Constants.ROLE));
        user.setPassword(request.getParameter(Constants.PASSWORD));
        user.setEmailId(request.getParameter(Constants.EMAILID));
        return user;
    }

    /**
     * <p>
     * This method is used by the Servlet to implement the Display,Create and
     * Modify operations on the Employee Details. This method called by the
     * Servlet to process these operations on the Employee.
     * </p>
     *
     * @param request contains the HttpServletRequest send by the Servlet.
     * @param response contains the HttpServletResponse send by the Servlet.
     */
    @RequestMapping(value="/login", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView login(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {
        try {
            String emailId = request.getParameter(Constants.EMAILID);
            String password = request.getParameter(Constants.PASSWORD);
            User user = null;
            if (null != emailId && null != password) {
                user = userService.getUserByEmailId(emailId);
            }
            if (null != user && password.equals(user.getPassword())) {
                HttpSession oldSession = request.getSession(Boolean.FALSE);
                if (null != oldSession) {
                   oldSession.invalidate();
                }
                HttpSession session = request.getSession(Boolean.TRUE);
                session.setAttribute(Constants.EMAILID,emailId);
                session.setAttribute(Constants.ROLE,user.getRole());
                session.setMaxInactiveInterval(Constants.SESSION_INTERVAL);
                System.out.println(session.getAttribute(Constants.EMAILID));
                Cookie loginCookie = new Cookie(Constants.USER,emailId);
                loginCookie.setMaxAge(Constants.SESSION_INTERVAL);
                response.addCookie(loginCookie);
                return new ModelAndView(Constants.LOGIN_SUCCESS_JSP);
            } else {
                return new ModelAndView(Constants.LOGINFILE, Constants.
                    WRONGUSER_ATTRIBUTE, Constants.WRONGUSER);
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
            Logger.error(e);
            return new ModelAndView(Constants.ERROR_JSP);
        }
    }

    /**
     * <p>
     * This method is used by the Servlet to implement the Display,Create and
     * Modify operations on the Employee Details. This method called by the
     * Servlet to process these operations on the Employee.
     * </p>
     *
     * @param request contains the HttpServletRequest send by the Servlet.
     * @param response contains the HttpServletResponse send by the Servlet.
     */
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public ModelAndView logout(HttpServletRequest request, 
            HttpServletResponse response) throws ServletException, IOException {

        response.setContentType(Constants.CONTENT_TYPE);
        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if (null != cookies) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(Constants.WRONGUSER_ATTRIBUTE)) {
                    loginCookie = cookie;
                    break;
    	        }
            }
        }
        if (null != loginCookie) {
            loginCookie.setMaxAge(0);
       	    response.addCookie(loginCookie);
        }
        HttpSession session = request.getSession(Boolean.FALSE);
        if (null != session) {
            session.invalidate();
            return new ModelAndView(Constants.LOGINFILE); 
        } else {
            return new ModelAndView(Constants.LOGIN_SUCCESS_JSP); 
        }
    }

    @RequestMapping(value="/index", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView index() {
        return new ModelAndView(Constants.LOGIN_SUCCESS_JSP); 
    }

    @RequestMapping(value="/indexLogin", method = {RequestMethod.POST,RequestMethod.GET})
    public ModelAndView indexLogin() {
        return new ModelAndView(Constants.LOGINFILE); 
    }
}
