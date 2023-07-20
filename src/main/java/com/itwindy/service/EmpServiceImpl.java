package com.itwindy.service;

import com.itwindy.pojo.Emp;
import com.itwindy.pojo.PageBean;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author windy
 * @create 2023-07-08 13:10
 */

public interface EmpServiceImpl {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin,LocalDate end);

    void delete(List<Integer> ids);

    void save(Emp emp);

    Emp getByid(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);


}
