package com.xz.parking.controller;

import com.xz.parking.dao.MenuDao;
import com.xz.parking.entity.vo.AdminVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
@Controller
@RequestMapping("/console")
public class ConsoleController {
    @Autowired
    private MenuDao menuDao;

    @GetMapping("/to_console")
    public ModelAndView toConsole() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("console");
        AdminVo admin = (AdminVo) SecurityUtils.getSubject().getSession().getAttribute("user");
        modelAndView.addObject("user", admin);
        menuDao.getMenu(null);
        return modelAndView;
    }

}
