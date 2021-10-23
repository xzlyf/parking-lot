package com.xz.parking.entity.vo;

import lombok.Data;

import javax.management.relation.Role;
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
    private Set<Role> roles;
    private Date createDate;
    private Date updateDate;
}
