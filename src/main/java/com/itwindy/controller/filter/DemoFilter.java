package com.itwindy.controller.filter;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author windy
 * @create 2023-07-10 18:45
 */
//@WebFilter(urlPatterns = "/*")
//public class DemoFilter implements Filter {
//    @Override//初始化方法，只调用一次
//    public void init(FilterConfig filterConfig) throws ServletException {
//        System.out.println("init 初始化方法执行了");
//    }
//
//    @Override//拦截到请求之后调用，调用多次
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        System.out.println("拦截到了请求");
//
//        filterChain.doFilter(servletRequest,servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//        System.out.println("destroy 销毁方法执行了");
//    }
//}
