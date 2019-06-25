package com.mycloud.auth.exception;

/**
 * @Author: hwz
 * @Date: 2018/10/18
 */
public class JwtException extends BizException {
    public JwtException() {
        super("用户未登录");
    }
}
