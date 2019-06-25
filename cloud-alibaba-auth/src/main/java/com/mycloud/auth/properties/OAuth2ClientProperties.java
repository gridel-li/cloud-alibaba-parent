package com.mycloud.auth.properties;

import lombok.Data;

/**
 * @Author: hwz
 * @Date: 2018/10/15
 */
@Data
public class OAuth2ClientProperties {

    /**
     * 第三方应用appId
     */
    private String clientId;
    /**
     * 第三方应用appSecret
     */
    private String clientSecret;
    /**
     * 针对此应用发出的token的有效时间
     */
    private int accessTokenValidateSeconds = 604800;

}
