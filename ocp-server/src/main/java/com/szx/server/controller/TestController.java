package com.szx.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Swagger 测试接口
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String hello() {
        return "hello";
    }

}
