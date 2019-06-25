package com.mycloud.auth.constant;

/**
 * @author liyingjie
 * @Title: Const
 * @Description:
 * @date 2019/6/14
 */
public class Const {

    //jwt签名
    public static final String JWT_SIGNING_KEY = "mycloud-spring-security-@Jwt!&Secret^#";

    public static class ResultObj {
        public static final Integer ERROR_CODE = 200;
    }

    public static final long EXPIRATION_TIME = 432_000_000;     // 5天(以毫秒ms计)
    public static final String SECRET = "CodeSheepSecret";      // JWT密码
    public static final String TOKEN_PREFIX = "Bearer";         // Token前缀
    public static final String HEADER_STRING = "Authorization"; // 存放Token的Header Key
}
