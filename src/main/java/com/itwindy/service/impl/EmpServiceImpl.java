package com.itwindy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itwindy.mapper.EmpMapper;
import com.itwindy.pojo.Emp;
import com.itwindy.pojo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author windy
 * @create 2023-07-08 13:11
 */
@Service
public class EmpServiceImpl implements com.itwindy.service.EmpServiceImpl {
    @Autowired
    private EmpMapper empMapper;

//    @Override
//    public PageBean page(Integer page, Integer pageSize) {
//        //获取总记录数
//        Long count = empMapper.count();
//
//        //获取分页查询结果列表
//        Integer start = (page-1) * pageSize;
//        List<Emp> empList = empMapper.page(start, pageSize);
//
//        PageBean pageBean = new PageBean(count, empList);
//        return pageBean;
//    }
@Override
    public PageBean page(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page,pageSize);
        //执行查询
        List<Emp> emplist = empMapper.list(name,gender,begin,end);
        Page<Emp> p = (Page<Emp>) emplist;
        //封装pageBean对象
        PageBean pageBean = new PageBean(p.getTotal(),p.getResult());
        return pageBean;







}

    /**
     * 批量删除员工的信息
     * @param ids
     */
    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }


    /**
     * 新增员工
     * @param emp
     */
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insert(emp);
    }

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    @Override
    public Emp getByid(Integer id) {
        return empMapper.getByid(id);
    }


    /**
     * 修改员工信息
     * @param emp
     */
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        emp.setCreateTime(LocalDateTime.now());
        empMapper.update(emp);

    }

    @Override
    public Emp login(Emp emp) {


        return empMapper.getByUsernameAndPassword(emp);
    }


}
