package com.myd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author myd
 * @date 2023/4/5  10:14
 */

//@EnableTransactionManagement
@SpringBootApplication
@MapperScan("com.myd.dao")
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class,args);
    }
}
