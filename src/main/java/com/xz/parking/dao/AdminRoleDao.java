package com.xz.parking.dao;

import com.xz.parking.entity.po.AdminRolePo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/24
 */
@Repository
public interface AdminRoleDao {
    Integer insert(List<AdminRolePo> list);

    Integer deleteById(Integer id);
}
