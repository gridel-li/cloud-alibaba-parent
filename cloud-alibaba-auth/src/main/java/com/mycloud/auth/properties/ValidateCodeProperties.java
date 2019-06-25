package com.mycloud.auth.properties;

import lombok.Data;

/**
 * 验证码配置
 * <p>
 * 图形验证码和短信验证码
 */
@Data
public class ValidateCodeProperties {

    /**
     * 图片验证码选项
     */
    private ImageCodeProperties imageCode = new ImageCodeProperties();

    /**
     * 短信验证码
     */
    private SmsCodeProperties smsCode = new SmsCodeProperties();

}
