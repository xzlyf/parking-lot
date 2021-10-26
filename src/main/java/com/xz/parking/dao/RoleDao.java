package com.xz.parking.dao;

import com.xz.parking.entity.po.AdminPo;
import com.xz.parking.entity.po.RolePo;
import com.xz.parking.entity.vo.AdminVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/24
 */
@Repository
public interface RoleDao {
    /**
     * 返回所有权限
     */
    List<RolePo> findAll();

    /**
     * 新增权限
     */
    int save(AdminPo adminPo);

    /**
     * 更新权限
     */
    int update(AdminPo adminPo);

    /**
     * 根据id删除权限
     */
    int deleteById(Integer id);

    /**
     * 根据id查找
     * @param id 权限id
     */
    RolePo findById(Integer id);
}
