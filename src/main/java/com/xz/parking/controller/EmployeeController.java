package com.xz.parking.controller;

import com.github.pagehelper.PageInfo;
import com.xz.parking.entity.Result;
import com.xz.parking.entity.ResultCode;
import com.xz.parking.entity.ResultPage;
import com.xz.parking.entity.po.RolePo;
import com.xz.parking.entity.vo.AdminAddVo;
import com.xz.parking.entity.vo.AdminUpdateVo;
import com.xz.parking.entity.vo.AdminVo;
import com.xz.parking.service.EmployeeService;
import com.xz.parking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/20
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    RoleService roleService;

    @GetMapping("/index")
    public String toEmployee() {
        return "system/employee";
    }

    @GetMapping("/index_add")
    public ModelAndView toAdd() {
        ModelAndView modelAndView = new ModelAndView();
        List<RolePo> all = roleService.findAll();
        modelAndView.addObject("roles", all);
        modelAndView.setViewName("system/employee_add");
        return modelAndView;
    }

    @GetMapping("/index_update")
    public ModelAndView toUpdate(@RequestParam String employeeNo) {
        ModelAndView modelAndView = new ModelAndView();
        List<RolePo> roles = roleService.findAll();
        AdminVo adminVo = employeeService.queryAdminByEmployeeNo(employeeNo);
        modelAndView.addObject("roles", roles);
        modelAndView.addObject("user", adminVo);
        modelAndView.setViewName("system/employee_update");
        return modelAndView;
    }


    @GetMapping(value = "/findAll", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object findAll(@RequestParam(value = "page", defaultValue = "1") Integer page,
                          @RequestParam(value = "size", defaultValue = "10") Integer size) {
        PageInfo<AdminVo> vo = employeeService.findAll(page, size);
        return ResultPage
                .ok(vo.getList())
                .total(vo.getTotal())
                .totalPage(vo.getPages())
                .currentPage(vo.getPageNum())
                .pageSize(vo.getSize())
                .code(ResultCode.SUCCESS);
    }

    @GetMapping(value = "/query", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object findOne(@RequestParam Integer type,
                          @RequestParam String value) {
        AdminVo adminVo = null;
        if (type != null && type == 1) {
            adminVo = employeeService.queryAdminByEmployeeNo(value);
        } else if (type != null && type == 2) {
            adminVo = employeeService.queryAdminByName(value).get(0);
        }
        if (adminVo == null) {
            return Result.failed(null).msg("????????????");
        }

        return ResultPage
                .ok(new Object[]{adminVo})//???????????????????????????????????????????????????layui?????????
                .total(1L)
                .totalPage(1)
                .currentPage(1)
                .pageSize(1)
                .code(ResultCode.SUCCESS);
    }

    @PostMapping("/add")
    @ResponseBody
    public Object addOne(AdminAddVo addVo) {
        if (employeeService.save(addVo.getName(), addVo.getPerms())) {
            return Result.ok(null).msg("????????????");
        } else {
            return Result.failed(null).msg("????????????");
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public Object updateOne(AdminUpdateVo updateVo) {
        int update = employeeService.update(updateVo);
        if (update != 0) {
            return Result.ok(null).msg("????????????");
        } else {
            return Result.failed(null).msg("????????????");
        }
    }

    @GetMapping("/delete")
    @ResponseBody
    public Object deleteMore(@RequestParam List<Integer> id) {
        int row = employeeService.deleteById(id);
        return Result.ok(row).msg("????????????");
    }


}
