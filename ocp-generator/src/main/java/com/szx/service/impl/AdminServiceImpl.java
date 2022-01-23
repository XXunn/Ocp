package com.szx.service.impl;

import com.szx.pojo.Admin;
import com.szx.mapper.AdminMapper;
import com.szx.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author szx
 * @since 2022-01-21
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
