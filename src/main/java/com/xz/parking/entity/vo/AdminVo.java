package com.xz.parking.entity.vo;

import lombok.Data;

import java.util.Date;

/**
 * @Author: xz
 * @Date: 2021/10/20
 */
@Data
public class AdminVo {
    private String employeeNo;
    private String name;
    private Boolean isEnable;
    private Date createDate;
    private Date updateDate;
}
