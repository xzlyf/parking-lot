package com.xz.parking.entity.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: xz
 * @Date: 2021/10/24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRolePo implements Serializable {
    private Integer adminId;
    private Integer roleId;
}
