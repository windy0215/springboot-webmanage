package com.itwindy.service.impl;

import com.itwindy.mapper.DeptMapper;
import com.itwindy.mapper.EmpMapper;
import com.itwindy.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author windy
 * @create 2023-07-08 13:10
 */
@Service
public class DeptServiceImpl implements com.itwindy.service.DeptServiceImpl {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;


    /**
     * 查询全部数据
     * @return
     */
    @Override
    public List<Dept> listt() {
        return deptMapper.listt();
    }

    /**
     * 删除部门
     * @param id
     */
    @Transactional(rollbackFor = Exception.class)//Spring事务管理
    @Override
    public void delete(Integer id) {
        int i=1/0;
        deptMapper.delete(id);

        empMapper.deleteByDeptId(id);//根据部门ID删除该部门下的员工
    }

    /**
     * 添加新部门
     * @param dept
     */
    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.add(dept);
    }




    /**
     * 根据id返回部门名字
     * @return
     */
    @Override
    public Dept findbyId(Integer id) {
        return deptMapper.getbyid(id);
    }




    /**
     * 修改部门
     * @param
     */
    @Override
    public void update(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }



}
