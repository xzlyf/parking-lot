package com.xz.parking.entity.po;

import lombok.Data;

/**
 * @Author: xz
 * @Date: 2021/10/26
 */
@Data
public class MenuPo {
    /**
     * 菜单id
     */
    private Integer id;
    /**
     * 菜单父id
     */
    private Integer parentId;
    /**
     * 菜单名字
     */
    private String name;
    /**
     * 菜单url
     */
    private String url;
}
