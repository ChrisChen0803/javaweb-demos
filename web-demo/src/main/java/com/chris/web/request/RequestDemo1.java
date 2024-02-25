package com.chris.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/req1")
public class RequestDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println(method);
        String contextPath = req.getContextPath();
        System.out.println(contextPath);
        StringBuffer url = req.getRequestURL();
        System.out.println(url.toString());
        String uri = req.getRequestURI();
        System.out.println(uri);
        String queryString = req.getQueryString();
        System.out.println(queryString);
        Map<String, String[]> map = req.getParameterMap();
        for(String key:map.keySet()){
            System.out.println(key+":");
            String[] values = map.get(key);
            for(String value:values){
                System.out.print(value+" ");
            }
            System.out.println();
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
