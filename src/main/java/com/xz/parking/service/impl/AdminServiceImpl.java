package com.xz.parking.service.impl;

import com.xz.parking.dao.AdminDao;
import com.xz.parking.entity.po.AdminPo;
import com.xz.parking.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;


    @Override
    public AdminPo queryAdminByEmployeeNo(String employeeNo) {
        return adminDao.queryAdminByEmployeeNo(employeeNo);
    }

}
