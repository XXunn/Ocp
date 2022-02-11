package com.szx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szx.server.pojo.Admin;
import com.szx.server.pojo.Menu;
import com.szx.server.pojo.RespBean;
import com.szx.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */

public interface  IAdminService extends IService<Admin> {
    /**
     * 登陆后返回token
     * @param username
     * @param password
     * @param code
     * @param request
     * @return
     */
    RespBean login(String username, String password, String code, HttpServletRequest request);

    /**
     * 根据用户名获取用户实体
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);

    /**
     * 根据id查询权限
     * @param adminId
     * @return
     */
    List<Role> getRoles(Integer adminId);

    /**'
     * 获取所有管理员
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(String keywords);

    /**
     * 更新管理员的角色
     * @param adminId
     * @param rids
     * @return
     */
    RespBean updateAdminRole(Integer adminId, Integer[] rids);
}
