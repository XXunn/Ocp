package com.szx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szx.server.pojo.Admin;
import com.szx.server.pojo.Menu;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
public interface AdminMapper extends BaseMapper<Admin> {

    /**
     * 通过 id , 查询用户有权限看到的菜单
     * @param id
     * @return
     */
    List<Menu> getMenusByAdminId(Integer id);
}
