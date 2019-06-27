package com.mycloud.auth.controller;

import com.mycloud.auth.domain.MyUser;
import com.mycloud.auth.exception.BizException;
import com.mycloud.auth.utils.JwtUtil;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author liyingjie
 * @Title: LoginController
 * @Description:
 * @date 2019/6/13
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @PostMapping("/aaa")
    public String aaa() throws BizException {
        MyUser user = JwtUtil.getUser();
        if (null!=user){
            System.out.println(user.toString());
        }else{
            System.out.println("user is null");
        }
        return "111";
    }


    @GetMapping("/sss")
    public String sss(@RequestParam(required = false) String id){
        System.out.println("id : "+id);
        return "success";
    }


    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
