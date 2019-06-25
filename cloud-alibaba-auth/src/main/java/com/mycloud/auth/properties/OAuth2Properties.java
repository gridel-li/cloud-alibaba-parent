package com.mycloud.auth.properties;

import lombok.Data;

/**
 * @Author: hwz
 * @Date: 2018/10/15
 */
@Data
public class OAuth2Properties {

    /**
     * 客户端配置
     */
    private OAuth2ClientProperties[] clients = {};


}
