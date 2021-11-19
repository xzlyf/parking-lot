package com.xz.parking.service.impl;

import com.xz.parking.dao.RoleDao;
import com.xz.parking.entity.po.RolePo;
import com.xz.parking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/28
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Override
    public List<RolePo> findAll() {
        return roleDao.findAll();
    }
}
