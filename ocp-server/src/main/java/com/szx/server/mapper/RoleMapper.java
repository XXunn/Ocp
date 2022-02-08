package com.szx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szx.server.pojo.Role;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getRoles(Integer adminId);
}
