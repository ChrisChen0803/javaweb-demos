package com.chris.web;

import com.chris.pojo.User;
import com.chris.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String vc = request.getParameter("veriCode");
        HttpSession session = request.getSession();
        String vcGen = (String) session.getAttribute("veriCodeGen");


        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean flag = service.register(user);
        if(!vcGen.equalsIgnoreCase(vc)){
            request.setAttribute("register_msg","Incorrect Verification Code");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
           return;
        }
        if(flag){
            request.setAttribute("register_msg","Register Successful! Please Login");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
        else{
            request.setAttribute("register_msg","Username already exists");
            request.getRequestDispatcher("/register.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}