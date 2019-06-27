package com.mycloud.auth.controller;

import com.mycloud.auth.domain.MyUser;
import com.mycloud.auth.exception.BizException;
import com.mycloud.auth.utils.JwtUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyingjie
 * @Title: LoginController
 * @Description:
 * @date 2019/6/13
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @GetMapping("/aaa")
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

}
