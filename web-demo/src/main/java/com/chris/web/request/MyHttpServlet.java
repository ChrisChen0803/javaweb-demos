package com.chris.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class MyHttpServlet implements Servlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //Obtain the type of request
        String method = request.getMethod();
        if("GET".equals(method)){
            doGet(servletRequest,servletResponse);
        } else if ("POST".equals(method)) {
            doPost(servletRequest,servletResponse);
        }
        else{
            return;
        }
    }

    protected void doGet(ServletRequest req, ServletResponse resp) {
        System.out.println("Get..");
    }
    protected void doPost(ServletRequest req, ServletResponse resp) {
        System.out.println("Post..");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
