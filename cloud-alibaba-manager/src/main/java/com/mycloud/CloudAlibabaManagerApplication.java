package com.mycloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class CloudAlibabaManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaManagerApplication.class, args);
    }
    @RestController
    class TestController{
        @GetMapping("bbb")
        public String aaa(){
            System.out.println("bbb");
            return "bbb";
        }
    }
}
