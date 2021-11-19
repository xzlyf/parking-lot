package com.xz.parking.entity.po;

import lombok.Data;

/**
 * @Author: xz
 * @Date: 2021/11/19
 */
@Data
public class DevicePo {
    private Integer id;
    private String tag;
    private String deviceId;
    private String location;
    private String ip;
    private String mac;
    private Integer adminId;
}
