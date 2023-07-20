package com.itwindy.service;

import com.itwindy.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author windy
 * @create 2023-07-08 13:09
 */

public interface DeptServiceImpl {
    List<Dept> listt();

    void delete(Integer id);

    void add(Dept dept);


    Dept findbyId(Integer id);

    void update(Dept dept);
}
