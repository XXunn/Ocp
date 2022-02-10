package com.szx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szx.server.pojo.Department;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
public interface IDepartmentService extends IService<Department> {

    /**
     * 获取所有部门
     * @return
     */
    List<Department> getAllDepartments();
}
