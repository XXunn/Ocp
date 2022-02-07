package com.szx.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sun.media.jfxmedia.logging.Logger;
import com.szx.server.mapper.MenuMapper;
import com.szx.server.pojo.Admin;
import com.szx.server.pojo.Menu;
import com.szx.server.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Integer adminId = ((Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
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

    @Override
    public List<Menu> getMenusWithRole() {
         return menuMapper.getMenusWithRole();
    }
}
