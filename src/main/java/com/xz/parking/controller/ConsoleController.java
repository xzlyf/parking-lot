package com.xz.parking.controller;

import com.xz.parking.dao.MenuDao;
import com.xz.parking.entity.dto.ScopeDto;
import com.xz.parking.entity.po.MenuPo;
import com.xz.parking.entity.vo.AdminVo;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
@Controller
@RequestMapping("/console")
public class ConsoleController {
    @Autowired
    private MenuDao menuDao;

    @GetMapping("/index")
    public ModelAndView toConsole() {
        ModelAndView modelAndView = new ModelAndView();
        AdminVo admin = (AdminVo) SecurityUtils.getSubject().getSession().getAttribute("user");
        ScopeDto scope = (ScopeDto) SecurityUtils.getSubject().getSession().getAttribute("scope");
        List<MenuPo> menu = menuDao.getMenuByPerms(scope.getScope());
        modelAndView.setViewName("console");
        modelAndView.addObject("user", admin);
        modelAndView.addObject("menuList", menu);
        return modelAndView;
    }

}
