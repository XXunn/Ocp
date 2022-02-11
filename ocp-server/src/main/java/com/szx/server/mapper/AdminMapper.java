package com.szx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.szx.server.pojo.Admin;
import com.szx.server.pojo.Menu;
import org.apache.ibatis.annotations.Param;

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
     *  获取所有管理员
     * @param id
     * @param keywords
     * @return
     */
    List<Admin> getAllAdmins(@Param("id") Integer id, @Param("keywords") String keywords);
}
