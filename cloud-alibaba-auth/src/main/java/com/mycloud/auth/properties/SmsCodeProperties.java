package com.mycloud.auth.properties;

import lombok.Data;

/**
 * @Author: hwz
 * @Date: 2018/10/15
 */
@Data
public class SmsCodeProperties {

    /**
     * 短信验证码的长度
     */
    private int length = 6;

    /**
     * 过期时间
     */
    private int expireIn = 300;

    /**
     * 需要处理的url
     */
    private String url;

}
