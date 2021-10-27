package com.xz.parking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xz
 * @Date: 2021/10/27
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @GetMapping("/index")
    public String toEmployee() {
        return "system/role";
    }
}
