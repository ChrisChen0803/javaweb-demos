package com.chris.web;

import com.chris.pojo.Brand;
import com.chris.pojo.User;
import com.chris.service.BrandService;
import com.chris.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String remember = request.getParameter("remember");
        User user = service.login(username,password);
        String contextPath = request.getContextPath();
        if(user!=null){
            if("1".equals(remember)){
                Cookie c_username = new Cookie("username",username);
                Cookie c_password = new Cookie("password",password);
                c_username.setMaxAge(60*60*7*24);
                c_password.setMaxAge(60*60*7*24);
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect(contextPath + "/selectAllServlet");
        }
        else{
            request.setAttribute("login_msg","Wrong username or password");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}