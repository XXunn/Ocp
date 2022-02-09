package com.szx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szx.server.pojo.MenuRole;
import com.szx.server.pojo.RespBean;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
public interface IMenuRoleService extends IService<MenuRole> {
    /**
     * 根据角色id, 更新菜单
     * @param rid
     * @param mids
     * @return
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);
}
