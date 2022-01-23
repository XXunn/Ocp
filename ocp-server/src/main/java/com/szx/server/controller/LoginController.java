package com.szx.server.controller;

import com.szx.server.pojo.Admin;
import com.szx.server.pojo.AdminLogin;
import com.szx.server.pojo.RespBean;
import com.szx.server.service.IAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

/**
 * 登录Controller
 */
@Api(tags = "LoginController")
@RestController
public class LoginController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "登陆后返回token")
    @PostMapping("/login")
    public RespBean login(@RequestBody AdminLogin adminLogin, HttpServletRequest request) {
        System.out.println("in login controller!");
        return adminService.login(adminLogin.getUsername(), adminLogin.getPassword(), request);
    }

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/admin/info")
    public Admin getAdminInfo(Principal principal) {
        if(principal == null) {
            return null;
        }
        // 获取用户名, principal可以从SecurityContext中直接取到
        String username = principal.getName();
        Admin admin = adminService.getAdminByUserName(username);
        admin.setPassword(null);
        return admin;
    }

    @ApiOperation(value="退出登录")
    @PostMapping("/logout")
    public RespBean logout() {
        return RespBean.success("注销成功!");
    }

}
