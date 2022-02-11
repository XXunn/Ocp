package com.szx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szx.server.pojo.AdminRole;
import com.szx.server.pojo.RespBean;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 更新管理员角色
     * @param adminId
     * @param rids
     * @return
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);
}
