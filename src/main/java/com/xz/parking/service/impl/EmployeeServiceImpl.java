package com.xz.parking.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xz.parking.dao.AdminRoleDao;
import com.xz.parking.dao.EmployeeDao;
import com.xz.parking.dao.RoleDao;
import com.xz.parking.entity.po.AdminPo;
import com.xz.parking.entity.po.AdminRolePo;
import com.xz.parking.entity.po.RolePo;
import com.xz.parking.entity.vo.AdminUpdateVo;
import com.xz.parking.entity.vo.AdminVo;
import com.xz.parking.service.EmployeeService;
import com.xz.parking.utils.RandomUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private AdminRoleDao adminRoleDao;

    @Override
    public PageInfo<AdminVo> findAll(Integer page, Integer size) {
        //PageHelper.startPage(page,5);
        //List <AdminPo> po = employeeDao.findAll();
        //实体类转换演示
        //List<AdminVo> vo = ColaBeanUtils.copyListProperties(po,AdminVo::new);
        //BeanUtils.copyProperties(vo,po);
        //PageInfo<AdminVo> pageInfo = new PageInfo<>(vo);
        //return pageInfo;
        PageHelper.startPage(page, size);
        List<AdminVo> po = employeeDao.findAll();
        PageInfo<AdminVo> pageInfo = new PageInfo<>(po);
        return pageInfo;
    }

    @Override
    public int save(AdminPo adminPo) {
        return employeeDao.save(adminPo);
    }

    @Override
    public boolean save(String name, Integer[] roleId) {
        try {
            AdminPo adminPo = new AdminPo();
            adminPo.setName(name);
            adminPo.setEmployeeNo(RandomUtils.randomNumber(6));
            adminPo.setPasswd("123456");
            adminPo.setIsEnable(true);
            employeeDao.save(adminPo);
            Set<RolePo> roles = insertAdminRoles(adminPo.getId(), roleId);
            adminPo.setRoles(roles);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public int update(AdminUpdateVo updateVo) {
        if (updateVo.getIsEnable()==null){
            updateVo.setIsEnable(false);
        }
        AdminPo po = new AdminPo();
        BeanUtils.copyProperties(updateVo, po);
        int update = employeeDao.update(po);
        insertAdminRoles(po.getId(), updateVo.getPerms());
        return update;
    }

    @Override
    public int deleteById(List<Integer> ids) {
        int row;
        adminRoleDao.deleteByAdminId(ids);
        row = employeeDao.deleteById(ids);
        return row;
    }

    @Override
    public List<AdminVo> queryAdminByName(String name) {
        return employeeDao.queryAdminByName(name);
    }

    @Override
    public AdminVo queryAdminByEmployeeNo(String employeeNo) {
        return employeeDao.queryAdminByEmployeeNo(employeeNo);
    }

    /**
     * 通用方法 把权限插入中间表
     *
     * @param adminId 用户id
     * @param roleId  权限id集合
     * @return 已插入的权限
     */
    private Set<RolePo> insertAdminRoles(Integer adminId, Integer[] roleId) {
        //如果存在，先删除
        List<Integer> del = new ArrayList<>();
        del.add(adminId);
        adminRoleDao.deleteByAdminId(del);

        List<AdminRolePo> adminRolePos = new ArrayList<>();
        Set<RolePo> roles = new HashSet<>();
        if (roleId != null) {
            RolePo role;
            for (Integer id : roleId) {
                role = roleDao.findById(id);
                if (role != null) {
                    roles.add(role);
                    adminRolePos.add(new AdminRolePo(adminId, role.getId()));
                }
            }
            adminRoleDao.insert(adminRolePos);
        }
        return roles;
    }
}
