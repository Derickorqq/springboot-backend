package com.hospital.hospitalgd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面路由类
 **/
@Controller
@RequestMapping("page")
public class RouteController {

    @RequestMapping("user")
    public String userPage(){
        return "user";
    }

    @RequestMapping("main")
    public String searchPage(){
        return "main";
    }

    @RequestMapping("login")
    public String login(){
        return "login";
    }
}
