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
    public Object findAll(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        PageInfo<AdminVo> vo = employeeService.findAll(page);
        return ResultPage
                .ok(vo.getList())
                .total(vo.getTotal())
                .totalPage(vo.getPages())
                .currentPage(vo.getPageNum())
                .pageSize(vo.getSize())
                .code(ResultCode.SUCCESS);
    }


}
