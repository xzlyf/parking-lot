package com.xz.parking.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: xz
 * @Date: 2021/10/19
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @GetMapping("/index")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password) {

        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);
            return "redirect:/console/index";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
        }
        return "redirect:/login/index";
    }

    @GetMapping("/logout")
    public String logout() {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login/index";
    }

    @GetMapping("/denied")
    @ResponseBody
    public String unAuth() {
        return "拒绝访问";
    }

}
