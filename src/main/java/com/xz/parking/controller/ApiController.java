package com.xz.parking.controller;

import com.xz.parking.entity.po.DevicePo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: xz
 * @Date: 2021/11/19
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/sign")
    public Object register(@RequestBody DevicePo devicePo) {
        return null;
    }
}
