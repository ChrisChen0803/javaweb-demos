package com.chris.web.servlet;

import com.alibaba.fastjson.JSON;
import com.chris.pojo.Brand;
import com.chris.pojo.PageBean;
import com.chris.service.BrandService;
import com.chris.service.impl.BrandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    private BrandService brandService = new BrandServiceImpl();
    public void selectAll(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Brand SelectAll");
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Brand Add");
        BufferedReader br = req.getReader();
        String params = br.readLine();
        Brand brand = JSON.parseObject(params,Brand.class);
        brandService.add(brand);
        res.getWriter().write("success");
    }

    public void deleteByIds(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Brand deleteByIds");
        BufferedReader br = req.getReader();
        String params = br.readLine();

        int[] ids = JSON.parseObject(params,int[].class);
        brandService.deleteByIds(ids);
        res.getWriter().write("success");
    }

    public void selectByPage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Brand selectByPage");
        String _currentPage = req.getParameter("currentPage");
        System.out.println(_currentPage);
        String _pageSize = req.getParameter("pageSize");
        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        //Service
        PageBean<Brand> pageBean = brandService.selectByPage(currentPage, pageSize);
        String jsonString = JSON.toJSONString(pageBean);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write(jsonString);
    }


    public void selectByPageAndCondition(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println("Brand selectByPage");

        String _currentPage = req.getParameter("currentPage");
        String _pageSize = req.getParameter("pageSize");

        int currentPage = Integer.parseInt(_currentPage);
        int pageSize = Integer.parseInt(_pageSize);

        // 获取查询条件对象
        BufferedReader br = req.getReader();
        String params = br.readLine();//json字符串

        //转为 Brand
        Brand brand = JSON.parseObject(params, Brand.class);

        System.out.println(currentPage);
        //Service
        PageBean<Brand> pageBean = brandService.selectByPageAndCondition(currentPage,pageSize,brand);
        String jsonString = JSON.toJSONString(pageBean);
        res.setContentType("text/json;charset=utf-8");
        res.getWriter().write(jsonString);
    }
}
