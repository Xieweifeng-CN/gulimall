package com.jack.gulimall.gulimallware;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.jack.gulimall.ware.dao")
@ComponentScan("com.jack.gulimall")
public class GulimallWareApplication {

    public static void main(String[] args) {
        SpringApplication.run(GulimallWareApplication.class, args);
    }

}
