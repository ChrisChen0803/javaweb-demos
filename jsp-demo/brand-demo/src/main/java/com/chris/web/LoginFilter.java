package com.chris.web;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String[] urls = {"/login.jsp","/imgs/","/css/","/loginServlet","/register.jsp","/registerServlet","VerificationCodeServlet"};

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String url = req.getRequestURL().toString();
        for(String u:urls){
            if(url.contains(u)){
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
        }
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if(user!=null){
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else{
            req.setAttribute("login_msg","You have not logged in!");
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
