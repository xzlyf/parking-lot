package com.xz.parking.entity.vo;

import lombok.Data;

/**
 * @Author: xz
 * @Date: 2021/10/28
 */
@Data
public class RoleVo {
    /**
     * 权限id
     */
    private Integer id;
    /**
     * 权限描述
     */
    private String description;
    /**
     * 权限名称
     */
    private String name;
}
