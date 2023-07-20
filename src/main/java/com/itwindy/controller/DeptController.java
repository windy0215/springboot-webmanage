package com.itwindy.controller;

import com.itwindy.pojo.Dept;
import com.itwindy.pojo.Result;
import com.itwindy.service.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author windy
 * @create 2023-07-08 13:08
 */
@RestController
@RequestMapping("/depts")
@Slf4j
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class);

//    @RequestMapping(value = "/depts",method = RequestMethod.GET)
    @Autowired
    private DeptServiceImpl deptService;

    /**
     * 查询部门数据
     * @return
     */
    @GetMapping
    public Result listt(){
        log.info("查询全部部门数据");

       List<Dept> deptList = deptService.listt();
        return Result.success(deptList);
    }

    /**
     * 删除部门
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("根据id删除部门",id);
        deptService.delete(id);
        return Result.success();
    }



    /**
     * 新增部门
     */
    @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.add(dept);
        return Result.success();

    }


    /**
     * 根据id查询
     */
    @GetMapping("/{id}")
    public Result getbyId(@PathVariable Integer id){
        Dept dept = deptService.findbyId(id);
        return Result.success(dept);
    }



    /**
     * 修改部门信息
     */
    @PutMapping
    public Result update(@RequestBody Dept dept){
        deptService.update(dept);

        return Result.success();
    }


}
