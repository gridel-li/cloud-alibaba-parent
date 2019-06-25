package com.mycloud.auth.utils;

import com.alibaba.fastjson.JSON;
import com.mycloud.auth.constant.Const;
import com.mycloud.auth.domain.MyUser;
import com.mycloud.auth.exception.BizException;
import com.mycloud.auth.exception.JwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @Author: hwz
 * @Date: 2018/6/6
 */
@Slf4j
public class JwtUtil {

    public static String getToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer "))
            return null;
        return StringUtils.substringAfter(header, "Bearer ");
    }

    public static String getUserId() throws BizException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = getToken(request);
        if (StringUtils.isNotBlank(token)) {
            Claims claims = null;
            try {
                claims = Jwts.parser().setSigningKey(Const.JWT_SIGNING_KEY.getBytes("UTF-8")).parseClaimsJws(token).getBody();
            } catch (UnsupportedEncodingException e) {
                log.error("Jwt解析错误",e);
                throw new JwtException();
            }
            if (claims.containsKey("user")){
                Map<String,String> user = (Map<String,String>)claims.get("user");
                return user.get("userId");
            }
        }
        log.info("Token not found");
        return null;
    }

    public static MyUser getUser() throws BizException, JwtException {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = getToken(request);
        if (StringUtils.isNotBlank(token)) {
            Claims claims = null;
            try {
                claims = Jwts.parser().setSigningKey(Const.JWT_SIGNING_KEY.getBytes("UTF-8")).parseClaimsJws(token).getBody();
            } catch (UnsupportedEncodingException e) {
                log.error("Jwt解析错误",e);
                throw new JwtException();
            }
            if (claims.containsKey("user")){
                Map<String,String> user = (Map<String,String>)claims.get("user");
                return JSON.parseObject(JSON.toJSONString(user),MyUser.class);
            }
        }
        return null;
    }

}
