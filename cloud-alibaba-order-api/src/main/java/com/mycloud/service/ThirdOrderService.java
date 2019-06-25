package com.mycloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liyingjie
 * @Title: ThirdOrderService
 * @Description:
 * @date 2019/6/5
 */
@FeignClient(name = "service-order",contextId = "third", path = "/api/thirdOrder")
public interface ThirdOrderService {

    @GetMapping("/getThirdOrderById")
    String getThirdOrderById(@RequestParam("id") String id);
}
