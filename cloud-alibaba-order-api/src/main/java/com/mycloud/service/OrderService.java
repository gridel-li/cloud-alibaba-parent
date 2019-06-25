package com.mycloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liyingjie
 * @Title: ApiService
 * @Description:
 * @date 2019/6/5
 */
@FeignClient(name = "service-order",contextId = "info",path = "/api/order")
public interface OrderService {

    @GetMapping("/getOrderById")
    String getOrderById(@RequestParam("id") String id);

}
