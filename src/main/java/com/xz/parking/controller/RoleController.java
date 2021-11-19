package com.xz.parking.controller;

import com.xz.parking.entity.ResultCode;
import com.xz.parking.entity.ResultPage;
import com.xz.parking.entity.po.RolePo;
import com.xz.parking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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
        List<RolePo> all = roleService.findAll();
        return ResultPage
                .ok(all)
                .total((long) all.size())
                .code(ResultCode.SUCCESS);
    }
}
