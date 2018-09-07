package com.ideas2it.employeeinformation.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ideas2it.employeeinformation.commons.constants.Constants;

/**
 * Authentication Filter implements filter to intercept all the request to
 * authenticate and authorise the User to manage the Application.
 * <p>
 * This Filter also gives Authorization only to the Users who are given 
 * privilege to the access those Functions.
 * </p>
 * All the CSS, Js And Images files get access through this filter.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
    }

    /**
     * <p>
     * This Method is used for providing the access privilege to the User and
     * checks all the Request that passes the Filter.
     * </p>
     * It checks whether the request is authorised or not.
     * @param request contains the ServletRequest send by the Servlet.
     * @param response contains the ServletResponse send by the Servlet.
     */
    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
            System.out.println(uri);
        HttpSession session = req.getSession(Boolean.FALSE);
            System.out.println(session);
        if (uri.indexOf(Constants.CSS) > 0 || uri.contains(Constants.
                IMAGES) || uri.indexOf(Constants.JS) > 0) {
            chain.doFilter(request, response);
        } else if (null == session ) {
            req.getRequestDispatcher(Constants.INDEX_LOGIN).forward(req,res);
        } else if (null == session.getAttribute(Constants.EMAILID)) {
            if (uri.endsWith(Constants.LOGINFILE)) {
                chain.doFilter(request, response);
            } else {
                req.getRequestDispatcher(Constants.INDEX_LOGIN).forward(req,res);
            }
        } else if (null != session && session.getAttribute(Constants.ROLE).
                equals(Constants.EMPLOYE) && (uri.contains(Constants.PROJECT_URL)
                || uri.contains(Constants.CLIENT_URI))) {
            res.sendRedirect(Constants.ERROR_REQUEST);
        } else if (null != session && null != session.getAttribute(Constants.
                EMAILID) && (uri.endsWith(Constants.LOGINFILE) || uri.endsWith(
                Constants.INDEX_LOGIN))) {
            res.sendRedirect(Constants.INDEX);
        } else {
            chain.doFilter(request, response);
        }
    }

    public void destroy() {
    }
}
