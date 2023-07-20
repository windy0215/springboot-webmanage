package com.itwindy.controller;

import com.itwindy.pojo.Emp;
import com.itwindy.pojo.PageBean;
import com.itwindy.pojo.Result;
import com.itwindy.service.EmpServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @author windy
 * @create 2023-07-08 13:08
 */
@RestController
@Slf4j
public class EmpController {
    @Autowired
    private EmpServiceImpl empService;

    @GetMapping("/emps")
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end)
    {
            log.info("分页查询，参数：{},{},{},{}",page,pageSize,name,gender,begin,end);
            //调用service分页查询
            PageBean pageBean = empService.page(page,pageSize,name,gender,begin,end);
            return Result.success(pageBean);
    }

    /**
     * 删除员工的信息
     */
    @DeleteMapping("/emps/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作，ids:{}",ids);
        empService.delete(ids);
        return Result.success();

    }

    /**
     * 新增员工
     */
    @PostMapping("/emps")
    public Result save(@RequestBody Emp emp){
        log.info("新增员工,emp:{}",emp);
        empService.save(emp);
        return Result.success();


    }

    /**
     * 编辑员工信息
     */
    @GetMapping("/emps/{id}")
    public Result getByid(@PathVariable Integer id){
        log.info("根据id来查询数据{}",id);
        Emp emp = empService.getByid(id);
        return Result.success(emp);


    }

    /**
     * 修改员工信息
     */
    @PutMapping("/emps")
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息",emp);
        empService.update(emp);
        return Result.success();
    }
}
