package com.mycloud.auth.properties;

import lombok.Data;

/**
 * @Author: hwz
 * @Date: 2018/10/15
 */
@Data
public class ImageCodeProperties extends SmsCodeProperties{

    public ImageCodeProperties() {
        setLength(4);
    }

    /**
     * 验证码的宽
     */
    private int width = 67;

    /**
     * 验证码的高
     */
    private int height = 23;

}
