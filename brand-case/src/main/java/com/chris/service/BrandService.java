package com.chris.service;

import com.chris.pojo.Brand;
import com.chris.pojo.PageBean;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandService {
    /**
     * Query All
     * @return List<Brand>
     */
    List<Brand> selectAll();

    /**
     * Insert data
     * @param brand
     */

    void add(Brand brand);

    /**
     * Delete Multiple Data
     * @param ids
     */
    void deleteByIds(int[] ids);

    /**
     *
     * @param currentPage
     * @param pageSize
     * @return PageBean
     */
    PageBean<Brand> selectByPage(int currentPage,int pageSize);

    /**
     *
     * @param currentPage
     * @param pageSize
     * @param brand
     * @return
     */
    PageBean<Brand> selectByPageAndCondition(int currentPage,int pageSize, Brand brand);



}
