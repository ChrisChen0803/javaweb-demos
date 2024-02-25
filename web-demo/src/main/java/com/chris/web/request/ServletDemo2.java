package com.chris.web;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/demo2")
public class ServletDemo2 extends MyHttpServlet {
    @Override
    protected void doGet(ServletRequest req, ServletResponse resp) {
        System.out.println("get..");
    }

    @Override
    protected void doPost(ServletRequest req, ServletResponse resp) {
        System.out.println("post..");
    }
}
