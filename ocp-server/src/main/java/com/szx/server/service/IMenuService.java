package com.szx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szx.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
public interface IMenuService extends IService<Menu> {
    /**
     * 根据用户id获取看得到的菜单列表
     * @return
     */
    List<Menu> getMenusByAdminId();

    /**
     * 根据角色权限获取列表
     * @return
     */
    List<Menu> getMenusWithRole();

}
