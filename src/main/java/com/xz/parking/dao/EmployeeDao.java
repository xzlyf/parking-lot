package com.xz.parking.dao;

import com.xz.parking.entity.po.AdminPo;
import com.xz.parking.entity.vo.AdminVo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/13
 */
@Repository
public interface EmployeeDao {

    /**
     * 返回所有管理员
     */
    List<AdminVo> findAll();

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
    int deleteById(List<Integer> id);

    /**
     * 通过用户名查找管理员
     */
    List<AdminVo> queryAdminByName(String name);

    /**
     * 通过员工号查找管理员
     */
    AdminVo queryAdminByEmployeeNo(String employeeNo);
}
