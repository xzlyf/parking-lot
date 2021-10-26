package com.xz.parking.service;

import com.xz.parking.entity.po.AdminPo;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
public interface AdminService {

    /**
     * 通过员工号查找管理员
     */
    AdminPo queryAdminByEmployeeNo(String employeeNo);

    /**
     * 通过id查找员工权限
     *
     * @return List<String>Scope  权限标识
     */
    List<String> queryRoleByAdminId(Integer id);
}
