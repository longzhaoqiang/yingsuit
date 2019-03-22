package com.yingsu.newbuss;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.yingsu.newbuss.mapper")
@EnableCaching
public class NewbussApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewbussApplication.class, args);
    }

}
