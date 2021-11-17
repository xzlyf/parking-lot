package com.xz.parking.controller;

import com.xz.parking.entity.ResultPage;
import com.xz.parking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xz
 * @Date: 2021/10/27
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/index")
    public String toEmployee() {
        return "system/role";
    }

    @GetMapping("/findAll")
    @ResponseBody
    public Object getRoles() {
        return ResultPage.ok(roleService.findAll());
    }
}
