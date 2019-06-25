package com.mycloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaGatewayApplication.class, args);
    }


    @RestController
    class TestController{
        @GetMapping("aaa")
        public String aaa(){
            System.out.println("sss");
            return "succ";
        }
    }
}
