package com.xz.parking.dao;

import com.xz.parking.entity.po.MenuPo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/26
 */
@Repository
public interface MenuDao {
    /**
     * 无需权限返回所有菜单
     */
    List<MenuPo> getMenu();

    /**
     * 根据权限返回所属菜单
     */
    List<MenuPo> getMenuByPerms(List<String> perms);
}
