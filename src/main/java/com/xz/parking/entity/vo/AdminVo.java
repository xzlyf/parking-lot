package com.xz.parking.entity.vo;

import com.xz.parking.entity.po.RolePo;
import lombok.Data;

import java.util.Date;
import java.util.Set;

/**
 * @Author: xz
 * @Date: 2021/10/20
 */
@Data
public class AdminVo {
    private Integer id;
    private String employeeNo;
    private String name;
    private Boolean isEnable;
    private Set<RolePo> roles;
    private Date createDate;
    private Date updateDate;
}
