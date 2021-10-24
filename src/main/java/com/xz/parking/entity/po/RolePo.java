package com.xz.parking.entity.po;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: xz
 * @Date: 2021/10/23
 */
@Data
public class RolePo implements Serializable {
    private Integer id;
    private String description;
    private String name;
    private String scope;
}
