package com.szx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szx.server.pojo.MenuRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
public interface MenuRoleMapper extends BaseMapper<MenuRole> {

    /**
     * 批量更新
     * @param rid
     * @param mids
     */
    Integer insertRecord(@Param("rid") Integer rid, @Param("mids") Integer[] mids);
}
