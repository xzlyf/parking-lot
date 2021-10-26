package com.xz.parking.entity.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xz
 * @Date: 2021/10/23
 */
@Data
public class RolePo implements Serializable {
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
    /**
     * 权限标识
     */
    private String scope;
}
