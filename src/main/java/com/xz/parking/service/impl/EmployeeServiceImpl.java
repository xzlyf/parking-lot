package com.xz.parking.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.parking.dao.EmployeeDao;
import com.xz.parking.entity.po.AdminPo;
import com.xz.parking.entity.vo.AdminVo;
import com.xz.parking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public PageInfo<AdminVo> findAll(Integer page, Integer size) {
        //PageHelper.startPage(page,5);
        //List <AdminPo> po = employeeDao.findAll();
        //实体类转换演示
        //List<AdminVo> vo = ColaBeanUtils.copyListProperties(po,AdminVo::new);
        //BeanUtils.copyProperties(vo,po);
        //PageInfo<AdminVo> pageInfo = new PageInfo<>(vo);
        //return pageInfo;
        PageHelper.startPage(page,size);
        List <AdminVo> po = employeeDao.findAll();
        PageInfo<AdminVo> pageInfo = new PageInfo<>(po);
        return pageInfo;
    }

    @Override
    public int save(AdminPo adminPo) {
        return employeeDao.save(adminPo);
    }

    @Override
    public int update(AdminPo adminPo) {
        return employeeDao.update(adminPo);
    }

    @Override
    public int deleteById(Integer id) {
        return employeeDao.deleteById(id);
    }

    @Override
    public List<AdminVo> queryAdminByName(String name) {
        return employeeDao.queryAdminByName(name);
    }

    @Override
    public AdminVo queryAdminByEmployeeNo(String employeeNo) {
        return employeeDao.queryAdminByEmployeeNo(employeeNo);
    }
}
