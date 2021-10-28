package com.xz.parking.service.impl;

import com.xz.parking.dao.RoleDao;
import com.xz.parking.entity.po.RolePo;
import com.xz.parking.entity.vo.RoleVo;
import com.xz.parking.service.RoleService;
import com.xz.parking.utils.ColaBeanUtils;
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
    public List<RoleVo> findAll() {
        List<RolePo> all = roleDao.findAll();
        List<RoleVo> vo = ColaBeanUtils.copyListProperties(all, RoleVo::new);
        return vo;
    }
}
