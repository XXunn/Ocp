package com.szx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szx.server.utils.AdminUtils;
import com.szx.server.mapper.MenuMapper;
import com.szx.server.pojo.Menu;
import com.szx.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<Menu> getMenusByAdminId() {
        Integer adminId = AdminUtils.getAdmin().getId();
        ValueOperations<String, Object> valueOps = redisTemplate.opsForValue();
        // 先从redis中找
        List<Menu> menus = (List<Menu>) valueOps.get("menu_" + adminId);
        // redis中没有就在mysql中找
        if(CollectionUtils.isEmpty(menus)) {
            menus = menuMapper.getMenusByAdminId(adminId);
            valueOps.set("menu_" + adminId, menus);
        }
        return menus;
    }

    /**
     * 根据角色查询对应的菜单列表
     * @return
     */
    @Override
    public List<Menu> getMenusWithRole() {
         return menuMapper.getMenusWithRole();
    }

    /**
     * 查询所有菜单
     * @return
     */
    @Override
    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
