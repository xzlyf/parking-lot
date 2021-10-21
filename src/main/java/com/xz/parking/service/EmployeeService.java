package com.xz.parking.service;

import com.github.pagehelper.PageInfo;
import com.xz.parking.entity.po.AdminPo;
import com.xz.parking.entity.vo.AdminVo;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
public interface EmployeeService {

    /**
     * 返回所有管理员
     */
    PageInfo<AdminVo> findAll(Integer page);

    /**
     * 新增管理员
     */
    int save(AdminPo adminPo);

    /**
     * 更新管理员
     */
    int update(AdminPo adminPo);

    /**
     * 根据id删除管理员
     */
    int deleteById(Integer id);

    /**
     * 通过用户名查找管理员
     */
    List<AdminPo> queryAdminByName(String name);

    /**
     * 通过员工号查找管理员
     */
    AdminPo queryAdminByEmployeeNo(String employeeNo);
}
