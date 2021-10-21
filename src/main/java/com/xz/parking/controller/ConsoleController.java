package com.xz.parking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: xz
 * @Date: 2021/10/15
 */
@Controller
@RequestMapping("/console")
public class ConsoleController {

    @GetMapping("/to_console")
    public String toConsole() {
        return "console";
    }

}
