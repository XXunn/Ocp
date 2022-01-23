package com.szx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szx.server.pojo.Admin;
import com.szx.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;

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
     * @param request
     * @return
     */
    RespBean login(String username, String password, HttpServletRequest request);

    /**
     * 根据用户名获取用户实体
     * @param username
     * @return
     */
    Admin getAdminByUserName(String username);
}
