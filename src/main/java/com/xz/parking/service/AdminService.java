package com.xz.parking.service;

import com.xz.parking.entity.po.AdminPo;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
public interface AdminService {

    /**
     * 通过员工号查找管理员
     */
    AdminPo queryAdminByEmployeeNo(String employeeNo);
}
