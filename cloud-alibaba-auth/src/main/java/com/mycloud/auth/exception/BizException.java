package com.mycloud.auth.exception;

/**
 * 业务异常，该异常会被返回到前端页面
 */
public class BizException extends CustomerException {
    public BizException(String message) {
        super(message);
    }
}
