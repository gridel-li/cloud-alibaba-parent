package com.mycloud.auth.exception;


import com.mycloud.auth.constant.Const;
import lombok.Getter;
import lombok.Setter;

/**
 * 所有自定义异常继承自此类
 * 2018-07-11
 *
 * @author qian
 */
public class CustomerException extends Exception {

    @Getter
    @Setter
    private Integer code = Const.ResultObj.ERROR_CODE;   // 错误码，若不设置则取默认值s

    /**
     * 构造函数，调用父类构造
     *
     * @param message 错误信息
     */
    public CustomerException(String message) {
        super(message);
    }
}
