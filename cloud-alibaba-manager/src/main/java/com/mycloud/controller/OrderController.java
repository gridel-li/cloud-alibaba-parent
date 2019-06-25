package com.mycloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.mycloud.service.OrderService;
import com.mycloud.service.ThirdOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyingjie
 * @Title: OrderController
 * @Description:
 * @date 2019/6/5
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private ThirdOrderService thirdOrderService;

    @GetMapping("/orderInfo")
    @SentinelResource(value = "/orderInfo",fallback = "sss",blockHandlerClass = Error.class)
    public String orderInfo(@RequestParam String id){
        String info = orderService.getOrderById(id);
        String thirdInfo = thirdOrderService.getThirdOrderById(id);
        System.out.println(info);
        System.out.println(thirdInfo);
        return "success";
    }
    @GetMapping("/sss")
    public String sss(@RequestParam (required = false) String id){
        String info = orderService.getOrderById(id);
        String thirdInfo = thirdOrderService.getThirdOrderById(id);
        System.out.println(info);
        System.out.println(thirdInfo);
        return "error";
    }
}
