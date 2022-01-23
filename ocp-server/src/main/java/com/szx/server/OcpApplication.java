package com.szx.server;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.szx.server.mapper")
public class OcpApplication {
    public static void main(String[] args) {
        SpringApplication.run(OcpApplication.class);
    }
}
