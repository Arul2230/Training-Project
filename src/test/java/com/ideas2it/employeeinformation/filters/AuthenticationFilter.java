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

public class AuthenticationFilter implements Filter {

    private ServletContext context;

    public void init(FilterConfig fConfig) throws ServletException {
        this.context = fConfig.getServletContext();
    }

    public void doFilter(ServletRequest request, ServletResponse response, 
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String uri = req.getRequestURI();
            System.out.println(uri);
        HttpSession session = req.getSession(Boolean.FALSE);
            System.out.println(session);
        if (null != session && (uri.equals(Constants.HOME) ||
                uri.endsWith(Constants.WELCOME_PAGE))) {
            if (null != session.getAttribute(Constants.EMAILID)) {
                res.sendRedirect(Constants.INDEX);
            } else {
                req.getRequestDispatcher(Constants.LOGINFILE).forward(req,res);
            }
        } else if (null != session && (uri.endsWith(Constants.USER_URL) || uri.
                endsWith(Constants.REGISTER) || uri.endsWith(Constants.INDEX) ||
                uri.contains(Constants.PROJECT_NAME))) {
            chain.doFilter(request, response);
        } else if (uri.indexOf(Constants.CSS) > 0 || uri.contains(Constants.
                IMAGES) || uri.indexOf(Constants.JS) > 0) {
            chain.doFilter(request, response);
        } else if (null != session && null == session.getAttribute(
                Constants.EMAILID)) {
            res.sendRedirect(Constants.HOME);
        } else if (null != session && session.getAttribute(Constants.ROLE).
                equals(Constants.EMPLOYE) && (uri.endsWith(Constants.CLIENT_URI)
                 || uri.endsWith(Constants.PROJECT_URI))) {
            req.setAttribute(Constants.ERROR,Constants.NOT_AUTHORISED);
            res.sendRedirect(Constants.ERROR_JSP);
        } else {
            req.getRequestDispatcher(Constants.INDEX_LOGIN).forward(request, 
                response);
        }
    }

    public void destroy() {
    }
}
