package com.mycloud.service.impl;

import com.mycloud.service.ThirdOrderService;
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
@RequestMapping("/api/thirdOrder")
@Slf4j
public class ThirdOrderServiceImpl implements ThirdOrderService {

    @Override
    public String getThirdOrderById(String id) {
        log.info("ThirdOrderServiceImpl id: " + id);
        return "这是ThirdId为" + id + " 的订单";
    }
}
