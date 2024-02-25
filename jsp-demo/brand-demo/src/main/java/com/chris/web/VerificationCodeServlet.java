package com.chris.web;

import com.chris.service.UserService;
import com.chris.util.VerificationCodeUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/verificationCodeServlet")
public class VerificationCodeServlet extends HttpServlet {
    private UserService service = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletOutputStream os = response.getOutputStream();
        String vc = VerificationCodeUtil.outputVerifyImage(100,50,os,4);

        HttpSession session = request.getSession();
        session.setAttribute("veriCodeGen",vc);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}