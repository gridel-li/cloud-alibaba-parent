package com.mycloud.auth.jwt;


import com.mycloud.auth.domain.MyUser;
import com.mycloud.auth.redis.RedisKey;
import com.mycloud.auth.redis.RedisTemplateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: hwz
 * @Date: 2018/6/1
 */
@Slf4j
public class JwtTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
        //往jwt添加的自定义信息
        log.info(authentication.getPrincipal().toString());
        UserDetails user = (UserDetails)authentication.getUserAuthentication().getPrincipal();
        Map<String , Object> info = new HashMap<>();
        info.put("---------------------------------user", RedisTemplateUtils.get(RedisKey.JWT_TOKEN_USER_ID_KEY + user.getUsername(), MyUser.class));
        ((DefaultOAuth2AccessToken)accessToken).setAdditionalInformation(info);
        return accessToken;
    }
}
