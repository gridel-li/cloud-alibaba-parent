package com.mycloud.service.impl;

import com.mycloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyingjie
 * @Title: OrderServiceImpl
 * @Description:
 * @date 2019/6/5
 */
@RestController
@RequestMapping("/api/order")
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Override
    public String getOrderById(String id) {
        log.info("OrderServiceImpl id: " + id);
        return "这是id为" + id + " 的订单";
    }
}
