package com.chris.web.response;

import org.apache.commons.io.IOUtils;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resp4")
public class ResponseDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("4");
        FileInputStream fis = new FileInputStream("d://a.jpg");
       ServletOutputStream os = resp.getOutputStream();
//       byte[] buff = new byte[1024];
//       int len = 0;
//       while((len=fis.read(buff))!=-1){
//           os.write(buff,0,len);
//       }
       IOUtils.copy(fis,os);
       fis.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
