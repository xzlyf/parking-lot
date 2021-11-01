package com.xz.parking.entity.vo;

import lombok.Data;

/**
 * @Author: xz
 * @Date: 2021/10/28
 * 注册管理员前端传入的实体类
 */
@Data
public class AdminAddVo {
    private String name;
    private String passwd;
    private Integer[] perms;
}
