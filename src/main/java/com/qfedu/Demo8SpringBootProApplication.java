package com.qfedu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qfedu.dao")
public class Demo8SpringBootProApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo8SpringBootProApplication.class, args);
    }
}
