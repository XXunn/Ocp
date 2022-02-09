package com.szx.server.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.szx.server.mapper.MenuRoleMapper;
import com.szx.server.pojo.Menu;
import com.szx.server.pojo.MenuRole;
import com.szx.server.pojo.RespBean;
import com.szx.server.service.IMenuRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
@Service
public class MenuRoleServiceImpl extends ServiceImpl<MenuRoleMapper, MenuRole> implements IMenuRoleService {

    @Autowired
    private MenuRoleMapper menuRoleMapper;

    /**
     * 根据角色id, 更新菜单
     * @param rid
     * @param mids
     * @return
     */
    @Override
    @Transactional
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        menuRoleMapper.delete(new QueryWrapper<MenuRole>().eq("rid", rid));
        // 不传, 相对于没更新
        if (mids == null || mids.length == 0) {
            return RespBean.success("更新成功!");
        }
        Integer res = menuRoleMapper.insertRecord(rid, mids);
        if( res == mids.length ) {
            return RespBean.success("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
}
