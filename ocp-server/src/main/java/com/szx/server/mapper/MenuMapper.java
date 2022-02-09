package com.szx.server.mapper;

import  com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> getMenusByAdminId(Integer id);

    List<Menu> getMenusWithRole();

    List<Menu> getAllMenus();
}
