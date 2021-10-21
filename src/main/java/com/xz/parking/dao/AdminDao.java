package com.xz.parking.dao;

import com.xz.parking.entity.po.AdminPo;
import org.springframework.stereotype.Repository;

/**
 * @Author: xz
 * @Date: 2021/10/21
 */
@Repository
public interface AdminDao {
    /**
     * 通过员工号查找管理员
     */
    AdminPo queryAdminByEmployeeNo(String employeeNo);

}
