package com.mycloud.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author liyingjie
 * @Title: LoginController
 * @Description:
 * @date 2019/6/13
 */
@Controller
public class LoginController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }


    @GetMapping("/ffff")
    public String ffff() {
        return "ffff";
    }
}
