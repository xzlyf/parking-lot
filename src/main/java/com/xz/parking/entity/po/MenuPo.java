package com.xz.parking.entity.po;

import com.xz.parking.dao.AdminDao;
import lombok.Data;

import java.awt.*;
import java.io.Serializable;
import java.util.List;


/**
 * @Author: xz
 * @Date: 2021/10/26
 */
@Data
public class MenuPo implements Serializable {
    /**
     * 菜单id
     */
    private Integer id;
    /**
     * 菜单父id
     */
    private Integer pid;
    /**
     * 菜单名字
     */
    private String name;
    /**
     * 菜单url
     */
    private String url;

    /**
     * 子菜单
     */
    private List<Menu> child;


}
