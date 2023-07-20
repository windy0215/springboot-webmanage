package com.itwindy.controller;

import com.itwindy.pojo.Emp;
import com.itwindy.pojo.Result;
import com.itwindy.service.impl.EmpServiceImpl;
import com.itwindy.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author windy
 * @create 2023-07-10 14:53
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private EmpServiceImpl empService;


    @PostMapping("/login")
    public Result login(@RequestBody Emp emp){
        log.info("员工登录:{}",emp);
        Emp e = empService.login(emp);

        if(e != null){
            Map<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt = JwtUtils.generateJwt(claims);
            return Result.success(jwt);
        }

        return Result.error("用户名或密码错误");
    }
}
