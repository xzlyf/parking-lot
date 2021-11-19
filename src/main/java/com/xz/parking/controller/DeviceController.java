package com.xz.parking.controller;

import com.xz.parking.entity.ResultPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xz
 * @Date: 2021/11/19
 */
@Controller
@RequestMapping("/device")
public class DeviceController {
    @GetMapping("/index")
    public String index() {
        return "parking/devices";
    }

    @GetMapping("/findAll")
    public Object findAll() {
        return ResultPage.failed(null);
    }
}
