package com.itwindy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

//@ServletComponentScan//开启了对servlet支持
@SpringBootApplication
public class SpringbootWebmanageApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebmanageApplication.class, args);
    }

}
