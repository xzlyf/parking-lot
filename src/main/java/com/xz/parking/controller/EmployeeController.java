package com.xz.parking.controller;

import com.github.pagehelper.PageInfo;
import com.xz.parking.entity.ResultCode;
import com.xz.parking.entity.ResultPage;
import com.xz.parking.entity.vo.AdminVo;
import com.xz.parking.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: xz
 * @Date: 2021/10/20
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/index")
    public String toEmployee() {
        return "system/employee";
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
        return ResultPage
                .ok(new Object[]{adminVo})//只有一个对象时需要封装成数组，不然layui不显示
                .total(1L)
                .totalPage(1)
                .currentPage(1)
                .pageSize(1)
                .code(ResultCode.SUCCESS);
    }

}
