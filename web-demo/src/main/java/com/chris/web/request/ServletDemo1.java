package com.chris.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.io.IOException;

@WebServlet(urlPatterns="/demo1",loadOnStartup = 1)
public class ServletDemo1 implements Servlet {
    private ServletConfig config;
    /*
    Everytime Servlet has been accessed.
    Called multiple times.
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //Dealing data differently based on the type of request
        System.out.println("Hello World");
    }
    @Override
    public void init(ServletConfig config) throws ServletException {
        this.config = config;
        System.out.println("Init");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }



    @Override
    public String getServletInfo() {
        return "";
    }

    /*
    Called when Releasing storage or shutting down server.
    Called once.
     */
    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
