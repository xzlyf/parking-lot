package com.xz.parking.dao;

import com.xz.parking.entity.po.AdminPo;
import com.xz.parking.entity.po.RolePo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

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

    /**
     * 通过id查找员工权限
     */
    List<String> queryRoleScopeByAdminId(Integer id);
}
