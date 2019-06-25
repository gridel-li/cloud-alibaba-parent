package com.mycloud.auth.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: hwz
 * @Date: 2018/10/15
 */
@Component
@ConfigurationProperties(prefix = "myauth.security")
@Data
public class SecurityProperties {

    /**
     * 验证码配置
     */
    private ValidateCodeProperties validateCode = new ValidateCodeProperties();

    /**
     * OAuth2认证服务器配置
     */
    private OAuth2Properties oauth2 = new OAuth2Properties();

}
