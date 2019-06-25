package com.mycloud.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liyingjie
 * @Title: ConfigController
 * @Description:
 * @date 2019/6/5
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${configTest}")
    private String configTest;

    @RequestMapping("/get")
    public String get() {
        return configTest;
    }


    /*private void init() throws Exception {
        String remoteAddress = yourRemoteAddress();
        String groupId = yourGroupId();
        String dataId = yourDataId();
        Converter<String, List<FlowRule>> parser = source -> JSON.parseObject(source,new TypeReference<List<FlowRule>>() {});
        ReadableDataSource<String, List<FlowRule>> nacosDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId, parser);
        FlowRuleManager.register2Property(nacosDataSource.getProperty());
    }*/

}
