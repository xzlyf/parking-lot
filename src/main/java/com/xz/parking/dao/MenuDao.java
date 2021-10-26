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
    List<MenuPo> getMenu(String[] perms);
}
