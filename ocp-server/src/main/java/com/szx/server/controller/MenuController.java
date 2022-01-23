package com.szx.server.controller;


import com.szx.server.pojo.Menu;
import com.szx.server.service.IAdminService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
@RestController
// 系统管理
@RequestMapping("/system/cfg")
public class MenuController {

    @Autowired
    private IAdminService adminService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId() {
        return adminService.getMenusByAdminId();
    }
}
