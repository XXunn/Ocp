package com.szx.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szx.server.pojo.Employee;
import com.szx.server.pojo.RespPageBean;

import java.time.LocalDate;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author szx
 * @since 2022-01-15
 */
public interface IEmployeeService extends IService<Employee> {

    /**
     * 分页显示所有员工
     * @param currentPage
     * @param size
     * @param employee
     * @param beginDateScope
     * @return
     */
    RespPageBean getEmployeeByPage(Integer currentPage, Integer size, Employee employee, LocalDate[] beginDateScope);
}
