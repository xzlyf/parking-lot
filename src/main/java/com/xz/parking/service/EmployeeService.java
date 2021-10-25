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
    PageInfo<AdminVo> findAll(Integer page, Integer size);

    /**
     * 新增管理员
     */
    int save(AdminPo adminPo);

    boolean save(String name, Integer[] roleId);

    /**
     * 更新管理员
     */
    int update(AdminPo adminPo);

    /**
     * 根据id删除管理员
     */
    int deleteById(List<Integer> ids);

    /**
     * 通过用户名查找管理员
     */
    List<AdminVo> queryAdminByName(String name);

    /**
     * 通过员工号查找管理员
     */
    AdminVo queryAdminByEmployeeNo(String employeeNo);
}
